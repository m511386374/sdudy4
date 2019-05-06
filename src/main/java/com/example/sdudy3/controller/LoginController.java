package com.example.sdudy3.controller;

import com.example.sdudy3.entity.UserEntity;
import com.example.sdudy3.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserJPA userJPA;

    @RequestMapping("/login")
    public String login(UserEntity user, HttpServletRequest request){
        boolean flag = true;
        String result = "登录成功";
        Optional<UserEntity> userEntity  = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"),user.getName()));
                return null;
            }
        });
        if(userEntity.get()==null){
            flag=false;
            result = "用户不存在，登录失败";
        }else if(!userEntity.get().getPwd().equals(user.getPwd())){
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        if(flag){
            request.getSession().setAttribute("_session_user",userEntity);
            System.out.println( request.getSession().getAttribute("_session_user").toString());
        }

     return result;
    }
}
