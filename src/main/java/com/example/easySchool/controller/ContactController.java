package com.example.easySchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {


    @RequestMapping(value = {"/contact"})
    public String displayCourses() {
        return "contact.html";
    }
}
