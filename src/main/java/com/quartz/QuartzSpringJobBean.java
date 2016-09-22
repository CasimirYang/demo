package com.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by yjh on 16/9/21.
 */
public class QuartzSpringJobBean extends QuartzJobBean
{

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }

    public static class ExampleBusinessObject{
        public void doIt() {
            // do the actual work
        }
    }
}