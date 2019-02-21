package com.tz.cms.activitimanage.listenner;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author maqilin
 * @description:
 * @date 2019/2/21 11:33
 */
public class ExcluTask implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("开始==delegateTask========");
        delegateTask.setAssignee("马其林");
    }
}
