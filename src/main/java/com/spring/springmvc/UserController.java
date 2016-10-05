package com.spring.springmvc;

import com.myBatis.UserModel;
import com.myBatis.spring.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

/**
 * @RequestParam 注解将请求参数绑定到你的控制器方法参数
 *
 */
@Controller
public class UserController {

    @Resource
    private ServiceImpl service;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        //i18n
        ApplicationContext ctx = RequestContextUtils.findWebApplicationContext(request);
       // String msg = ctx.getMessage("test.error", null, Locale.CHINA);

        int userId = Integer.parseInt(request.getParameter("id"));
        List<UserModel> list = this.service.getUsers();
        for (UserModel item : list)
        {
           System.out.println(item.getUid());
        }
        // model.addAttribute("user", user);
        System.out.println("spring mvc-----:"+Thread.currentThread().getId());
        model.addAttribute("greeting", "Hello Spring MVC");
        return "showUserPage";
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