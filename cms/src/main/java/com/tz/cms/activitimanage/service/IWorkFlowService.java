package com.tz.cms.activitimanage.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
 
public interface IWorkFlowService {

	/**
	 * 获取所有的流程部署对象
	 * @return
	 */
	public List<Deployment> getDeployments();

	/**
	 * 执行流程部署(zip格式)
	 * @param file
	 * @param deploymentName
	 */
	public Deployment addDeployment(InputStream inputStream, String deploymentName);
	
	/**
	 * 删除流程部署信息
	 * @param deploymentId
	 * @param flag
	 */
	public void delDeployment(String deploymentId, boolean flag);
	
	/**
	 * 获取所有的流程定义信息
	 * @return
	 */
	public List<ProcessDefinition> getProcessDefinitions();
	
	/**
	 * 根据部署id和流程图的名称获取流程图的inputStream
	 * @param deploymentId
	 * @param imageName
	 * @return
	 */
	public InputStream getProcessDefinitionImageStream(String deploymentId, String imageName);

	/**
	 * 根据流程定义的key和业务关系key和流程变量启动流程
	 * @param leaveProcessKey
	 * @param businessKey
	 * @param variables
	 */
	public ProcessInstance startProcess(String leaveProcessKey, String businessKey, Map<String, Object> variables);
	

	/**
	 * 根据任务ID获取流程图设置的formkey
	 * @param taskId
	 * @return
	 */
	public String getTaskFormKeyByTaskId(String taskId);

	
	/**
	 * 根据当前用户id查询当前用户的代办任务
	 * @Title: getTaskList  
	 * @Description: TODO
	 * @param assingnee
	 * @return
	 */
	public List<Task> getTaskList(String assingnee);
	
	
	/**
	 * 根据任务id获取任务对象
	 * @Title: getTaskById  
	 * @Description: TODO
	 * @param taskId
	 * @return
	 */
	public Task getTaskById(String taskId);
	
	/**
	 * 根据流程实例ID获取流程实例对象
	 * @Title: getProcessInstanceById  
	 * @Description: TODO
	 * @param ProcessInstanceId
	 * @return
	 */
	public ProcessInstance getProcessInstanceById(String processInstanceId);
	
	/**
	 * 根据任务id获取当前任务完成以后的连线信息
	 * @Title: getOutcomeListByTaskId  
	 * @Description: TODO
	 * @param taskId
	 * @return
	 */
	public List<PvmTransition> getOutcomeListByTaskId(String taskId) ;
	
	/**
	 * 根据任务id完成任务
	 * @Title: completeTask  
	 * @Description: TODO
	 * @param taskId
	 * @param outcome
	 * @param commentMsg
	 * @return
	 */
	public ProcessInstance completeTask(String taskId, String outcome, String commentMsg);
	
	/**
	 * 根据任务ID获取流程实例ID获取整个流程实例的评论
	 * @param taskId
	 * @return
	 */
	public List<Comment> getCommentListByTaskId(String taskId);
	
	
	/**
	 * 根据流程实例id获取当前活动的坐标
	 * @param processInstanceId
	 * @return
	 */
	public ActivityImpl getActivitiCoordinate(String processInstanceId);
	
	/**
	 * 根据流程实例id获取流程定义对象
	 * @param processInstanceId
	 * @return
	 */
	public ProcessDefinition getProcessDefinitonByInstanceId(String processInstanceId);

	
}