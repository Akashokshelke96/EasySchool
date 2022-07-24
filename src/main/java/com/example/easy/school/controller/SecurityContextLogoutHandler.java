package com.example.easy.school.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityContextLogoutHandler {


    private boolean invalidateHttpSession = true;

    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        Assert.notNull(request,"HttpServletRequest required");
        if(this.invalidateHttpSession){

        }
    }
}
