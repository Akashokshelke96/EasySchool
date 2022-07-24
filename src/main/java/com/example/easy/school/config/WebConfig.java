package com.example.easy.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//this way we can create view controller  for different pages using this registry and WEBMvcConfigurer
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/about").setViewName("about");

    }

}
