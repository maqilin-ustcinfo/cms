package com.tz.cms.activititest;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.sun.org.apache.bcel.internal.generic.LSTORE;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author maqilin
 * @description: 请假流程测试
 * @date 2019/2/18 16:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class LeaveTest {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RepositoryService repositoryService;

    /**
     *   流程部署
     *   流程部署表 act_re_deployment
     * 	 流程定义表 act_re_procdef
     * 	 流程资源表 act_ge_bytearray
     */
    @Test
    public void testLeaveProcessDePloy(){
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/leave.bpmn")
                .addClasspathResource("diagrams/leave.png")
                .deploy();
        System.out.println("deployment部署的id="+deployment.getId());
        System.out.println("deployment部署的名称="+deployment.getName());
    }


    /**
     * 查询流程部署信息
     */
    @Test
    public void testQueryProcessDefination(){
        String key = "leave";
        List<ProcessDefinition> processDefinitionList =
                processEngine.getRepositoryService().createProcessDefinitionQuery()
                .processDefinitionKey(key)
                .orderByProcessDefinitionVersion().desc()
                .listPage(0,1);
        System.out.println("processDefinitionList=="+processDefinitionList.size());
        for(ProcessDefinition definition:processDefinitionList){
            System.out.println("====="+definition.getId());
            System.out.println("====="+definition.getKey());
            System.out.println("====="+definition.getVersion());
            System.out.println("====="+definition.getDiagramResourceName());
            System.out.println("====="+definition.getResourceName());
        }
    }

    @Test
    public void testImage(){
        String deploymentId = "12501";
        List<String> names =
                processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);
        String fileName = "";
        for(String name:names){
            System.out.println("name="+name);
            if(name.indexOf(".png")>0){
                fileName  = name;
            }
        }

        File file = new File("C:\\Users\\maqilin\\logs\\"+fileName);

        InputStream inputStream =
                processEngine.getRepositoryService().getResourceAsStream(deploymentId,fileName);

        try {
            FileUtils.copyInputStreamToFile(inputStream,file);
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                    System.out.println("close完成");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 测试删除流程部署
     */
    @Test
    public void testDeleteProcessDefination(){
        String key = "myProcess";
        String deploymentId = "42501";
        //processEngine.getRepositoryService().deleteDeployment(deploymentId);
        //强制删除，运行中
        processEngine.getRepositoryService().deleteDeployment(deploymentId,true);
        System.out.println("删除完成");
    }






    /**
     * 流程启动
     * 流程的启动(流程实例的产生) keshao请假的一个流程实例 new Class->Object
     * 	 * 涉及到的表 :
     * 	 * 			act_ru_execution  流程实例表
     * 	 * 			act_ru_task 会产生一条待执行的任务记录
     * 	 * 			act_hi_taskinst 也会产生一条历史任务记录(注意:endtime is null)
     * 	 * 注意: 以流程定义的key启动的话,默认会进入版本最新的流程
     */
    @Test
    public void testStartProcess(){
        String key = "myProcess";
        Map<String, Object> variables = new HashMap<>();
        variables.put("userId","tds");
        ProcessInstance processInstance =  processEngine.getRuntimeService()
                .startProcessInstanceByKey(key,variables);
        System.out.println(processInstance.getProcessInstanceId());//80001
        System.out.println(processInstance.getProcessDefinitionId());
    }

    /**
     * 查询当前流程走到那个环节
     */
    @Test
    public void testQueryProcess(){
        String processInstanceId = "80001";
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();
        if(processInstance == null ){
            System.out.println("当前流程结束");
        }else{
            System.out.println("当前流程已经走到："+processInstance.getActivityId()+"环节");
        }
    }


    /**
     * 查询任务
     * act_ru_task
     *   流程变量(通过流程变量的设置来控制流程的走向(排它网关)
     *  当某个流程实例执行完以后以后,在流程实例表表act_ru_variable中的记录会被删除 ,
     * 	但是 act_hi_varinst表中存储了历史记录
     * 	任务的指定人：
     * 	    单个人：mql ; ${userId};监听类实现TaskListener接口
     * 	    一组人或者角色多一个任务拾取的过程。
     * 	    一组人：mql,tds;${userIdS};监听类实现TaskListener接口
     * 	    某个角色：R110;${XXX};监听类实现TaskListener接口
     *
     */
    @Test
    public void testQueryTask(){
        String taskAssignee = "马其林";
        String processInstanceId = "80001";
        List<Task> taskList = processEngine.getTaskService().createTaskQuery()
                .taskAssignee(taskAssignee)
                .processInstanceId(processInstanceId)
                .list();
        System.out.println("taskList="+taskList.size());
        String taskId = null;
        for (Task task:taskList){
            System.out.println("执行的人："+task.getAssignee());
            System.out.println("流程实例ID："+task.getProcessInstanceId());
            System.out.println("任务ID:"+task.getId());//27504 30004
            System.out.println("任务名称："+task.getName());
            taskId = task.getId();
        }

       /* // 设置流程变量
        processEngine.getTaskService().setVariable(taskId,"请假原因","肚子疼");
        processEngine.getRuntimeService().setVariable(processInstanceId,"请假原因r","肚子痛");
        processEngine.getTaskService().complete(taskId);

        processEngine.getTaskService().setVariableLocal(taskId,"请假原因","不想上班");
        processEngine.getRuntimeService().setVariableLocal(processInstanceId,"请假原因1","不想上班1");
        processEngine.getTaskService().complete(taskId);*/

       // 获取流程变量
        /*System.out.println(processEngine.getTaskService().getVariable(taskId,"请假原因"));
        System.out.println("=================");
        System.out.println(processEngine.getRuntimeService().getVariable(processInstanceId,"请假原因r"));
        processEngine.getTaskService().complete(taskId);
        System.out.println("完成任务");
        System.out.println("1="+processEngine.getTaskService().getVariableLocal("37504","请假原因"));
        System.out.println("=================");
        System.out.println("2="+processEngine.getRuntimeService().getVariableLocal(processInstanceId,"请假原因1"));
        System.out.println("3="+processEngine.getRuntimeService().getVariable(processInstanceId,"请假原因1"));
        */
        //processEngine.getTaskService().setVariable(taskId,"money",600);
        processEngine.getTaskService().complete(taskId);
    }

    /**
     * 完成任务
     */
    @Test
    public void completeTask(){
        String taskId = "17502";
        processEngine.getTaskService().complete(taskId);
        System.out.println("完成");
    }


    /**
     * 当某个任务结束以后,在任务表act_ru_task中的记录会被删除 ,
     * 但是act_hi_taskinst记录的endtime会加上 ,所以我们可以从这个表查询我们的任务执行历史记录
     *    一个流程实例就一条信息：act_hi_procinst === createHistoricProcessInstanceQuery
     *    一个流程实例各个环节信息：act_hi_taskinst === createHistoricTaskInstanceQuery
     */
    @Test
    public void testQueryHistory(){
        String processInstanceId = "15001";
        /*List<HistoricProcessInstance> historicProcessInstanceList = processEngine.getHistoryService()
                .createHistoricProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .list();

        for(HistoricProcessInstance historicProcessInstance :historicProcessInstanceList){
            System.out.println("historicProcessInstance="+historicProcessInstance.getName());
            System.out.println("historicProcessInstance="+historicProcessInstance.getStartTime());
            System.out.println("historicProcessInstance="+historicProcessInstance.getEndTime());
            System.out.println("============");
        }*/
        //processEngine.getFormService()
        List<HistoricTaskInstance> HistoricTaskInstanceList =
                processEngine.getHistoryService().createHistoricTaskInstanceQuery()
                .processInstanceId(processInstanceId)
                .list();

        for(HistoricTaskInstance t : HistoricTaskInstanceList){
            System.out.println("环节名称："+t.getName());
            System.out.println("环节开始时间："+t.getStartTime());
            System.out.println("环节结束时间："+t.getEndTime());
            System.out.println("======");
        }

    }

}
