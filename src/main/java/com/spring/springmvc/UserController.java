package com.spring.springmvc;

import com.myBatis.UserModel;
import com.myBatis.spring.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yjh on 16/10/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private ServiceImpl service;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        List<UserModel> list = this.service.getUsers();
        for (UserModel item : list)
        {
           System.out.println(item.getUid());
        }
        // model.addAttribute("user", user);
        return "showUser";
    }
}