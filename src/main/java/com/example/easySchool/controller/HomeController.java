package com.example.easySchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "/home"})
    public String displayHomePage(Model model){ //model acts as an interface between our UI and backend code...as a container holding the values.
        model.addAttribute("username","Akash Shelke Human");
       return "home.html";
    }
}
