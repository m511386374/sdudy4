package com.example.sdudy3.controller;
import com.example.sdudy3.entity.UserEntity;
import com.example.sdudy3.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/list")
    private List<UserEntity> getList(){
        return userJPA.findAll();
    }
    @RequestMapping("/add")
    private UserEntity addUser(UserEntity userEntity){
        return userJPA.save(userEntity);
    }
}
