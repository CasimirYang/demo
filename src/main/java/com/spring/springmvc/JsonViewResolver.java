package com.spring.springmvc;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by yjh on 16/10/6.
 */
public class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        Logger logger1 = Logger.getLogger("console");
        logger1.info("JsonViewResolver resolveViewName-----:"+viewName);
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }

}