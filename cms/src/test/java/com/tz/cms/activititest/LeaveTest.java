package com.tz.cms.activititest;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author maqilin
 * @description: 请假流程测试
 * @date 2019/2/18 16:12
 */
public class LeaveTest {

    private ProcessEngine processEngine;

    @Before
    public void init(){
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    /**
     *   流程部署表 act_re_deployment
     * 	 流程定义表 act_re_procdef
     * 	 流程资源表 act_ge_bytearray
     */
    @Test
    public void testLeaveProcessDePloy(){
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/leaveProcess.bpmn")
                .addClasspathResource("diagrams/leaveProcess.png")
                .deploy();
        System.out.println("deployment部署的id="+deployment.getId());
        System.out.println("deployment部署的名称="+deployment.getName());
    }

    /**
     * act_ru_execution
     */
    @Test
    public void testStartProcess(){
        String key = "myProcess";
        ProcessInstance processInstance =  processEngine.getRuntimeService()
                .startProcessInstanceByKey(key);
        System.out.println(processInstance.getDeploymentId());
        System.out.println(processInstance.getName());
        System.out.println(processInstance.getProcessInstanceId());//2501
        System.out.println(processInstance.getProcessDefinitionId());//myProcess:1:4
    }

    /**
     * act_ru_task
     */
    @Test
    public void testQueryTask(){
        List<Task> taskList = processEngine.getTaskService().createTaskQuery()
                //.taskAssignee("zhang")
                .processInstanceId("2501")
                .list();
        System.out.println("taskList="+taskList.size());
        for (Task task:taskList){
            System.out.println(task.getAssignee());
            System.out.println(task.getProcessInstanceId());
            System.out.println(task.getId());//2504
            System.out.println(task.getName());
        }
    }

    /**
     *
     */
    @Test
    public void completeTask(){
        String taskId = "5002";
        processEngine.getTaskService().complete(taskId);
        System.out.println("完成");
    }

}
