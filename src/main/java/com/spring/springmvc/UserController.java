package com.spring.springmvc;

import com.myBatis.UserModel;
import com.myBatis.spring.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @RequestParam 注解将请求参数绑定到你的控制器方法参数
 *
 */
@Controller
@SessionAttributes("greeting")
public class UserController {
    int bb =3;

    @Autowired
    private ServiceImpl service;

    @RequestMapping("/showUser")
    @ResponseBody
    public Model toIndex(HttpServletRequest request, HttpServletResponse response, Model model){
        //i18n
        ApplicationContext ctx = RequestContextUtils.findWebApplicationContext(request);
       // String msg = ctx.getMessage("test.error", null, Locale.CHINA);
        int userId = Integer.parseInt(request.getParameter("id"));
        service.getCid(1);
//        List<UserModel> list = this.service.getUsers();
//        for (UserModel item : list)
//        {
//           System.out.println(item.getUid());
//        }
        // model.addAttribute("user", user);
//        try {
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
       // response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        System.out.println("spring mvc-----:"+Thread.currentThread().getId());
//        model.addAttribute("greeting", "Hello Spring MVC");
//        if(userId==1){
//            throw new NullPointerException("eee");
//        }
        model.addAttribute("name", userId);
        return model;
    }


    @RequestMapping(value = "/somePath",method = RequestMethod.GET)
    public String requestResponseExample(HttpServletRequest request,
                                         HttpServletResponse reponses, Model model,
                                         @RequestParam(value = "name", defaultValue = "Guest") String name) {

        model.addAttribute("name", name);

        //使用前缀 "redirect:" ，该方法返回字符串，可以重定向到另一页面。参见图：
        return "redirect:/hello";
    }



}