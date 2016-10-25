package com.webservice.cxf;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.util.logging.Logger;

/**
 * Created by yjh on 16/10/16.
 */
public class SoapAuth  extends AbstractPhaseInterceptor<SoapMessage> {

    public SoapAuth() {
        //在哪个阶段被拦截
        super(Phase.PRE_PROTOCOL);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        System.out.println("=========>message:" + message);
        Logger logger = Logger.getLogger("SoapAuth");
        logger.info("-----header:"+message.getHeaders().toString());
    }
}
