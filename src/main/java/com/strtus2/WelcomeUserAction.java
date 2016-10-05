package com.strtus2;

import com.myBatis.spring.ServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * 实现接口ServletRequestAware,ServletResponseAware 获取request 和 response
 */
public class WelcomeUserAction implements ServletRequestAware {


    private ServiceImpl service;

    public ServiceImpl getService() {
        return service;
    }


    private HttpServletRequest request;
    //实现接口中的方法
    public void setServletRequest(HttpServletRequest request){
        this.request = request;
    }

    public void setService(ServiceImpl service) {
        this.service = service;
    }

    // all struts logic here
    public String execute() {


        Logger logger1 = Logger.getLogger("console");
        logger1.info("WelcomeUserAction execute-----:"+Thread.currentThread().getId());

        logger1.info(String.valueOf(request.getCookies()));
        logger1.info(String.valueOf(service.getCid(1)));

        return SUCCESS;

    }


}
