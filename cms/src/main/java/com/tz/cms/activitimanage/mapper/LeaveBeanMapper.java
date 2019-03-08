package com.tz.cms.activitimanage.mapper;

import java.util.List;
import com.tz.cms.activitimanage.entity.LeaveBean;
 
public interface LeaveBeanMapper {
	
	public List<LeaveBean> getLeaveBeanList(LeaveBean leaveBean);
	 
	public LeaveBean getLeaveBeanById(Long leaveId);
	
	public boolean addLeaveBean(LeaveBean leaveBean);
	
	public boolean delLeaveBean(Long leaveId);
	 
	public boolean updateLeaveBeanState(Long leaveId, Integer state);
	
	public boolean updateLeaveBeanProcessInstanceId(Long leaveId, String processInstanceId);
	  
	public boolean updateLeaveBean(LeaveBean leaveBean);
	
	
}
