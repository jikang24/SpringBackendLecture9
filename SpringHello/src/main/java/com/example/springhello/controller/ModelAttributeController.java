package com.example.springhello.controller;

import com.example.springhello.request.UserRequest;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModelAttributeController {

    @PostMapping("/users3/form")
    @ResponseBody
    public String submit(@ModelAttribute UserRequest form) {
        return "name=" + form.getName() + ", age=" + form.getAge();
    }

}
