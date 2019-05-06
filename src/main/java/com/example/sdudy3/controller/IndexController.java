package com.example.sdudy3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/indexView")
    public String index(){
        return "index";
    }
    @RequestMapping("/loginView")
    public String login(){
        return "login";
    }
}
