package com.spring.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;
import java.util.logging.Logger;

/**
 * student validate
 */
@Controller
@SessionAttributes("sections")
public class StudentController {


    @RequestMapping(value = "/test/{player}", method = RequestMethod.GET)
    public String newRegistration(@PathVariable String player, ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "enroll";
    }

    // @Valid要求spring来验证相关的对象(学生)。 BindingResult包含此验证，并可能在此验证过程中发生(产生)任何错误的结果。
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public String saveRegistration(HttpSession session, @Valid Student student, BindingResult result, ModelMap model){

        Logger logger1 = Logger.getLogger("console");
        logger1.info("StudentController saveRegistration-----:"+session.toString());
        if(result.hasErrors()) {
            return "enroll";
        }

        model.addAttribute("success", "Dear "+ student.getFirstName()+" , your Registration completed successfully");
        return "success";
    }

    //绑定对象以“sections”为名称添加到模型对象中供视图页面使用
    @ModelAttribute("sections")
    public List<String> initializeSections() {
        List<String> sections = new ArrayList<String>();
        sections.add("Graduate");
        sections.add("Post Graduate");
        sections.add("Research");
        return sections;
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> runtimeExceptionHandler(RuntimeException runtimeException) {
        //logger.error(runtimeException.getLocalizedMessage());
        Map model = new TreeMap();
        model.put("status", false);
        return model;
    }

}
