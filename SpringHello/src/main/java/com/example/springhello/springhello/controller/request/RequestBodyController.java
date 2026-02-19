package com.example.springhello.springhello.controller.request;

import com.example.springhello.springhello.request.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestBodyController {

    @PostMapping("/users2")
    @ResponseBody
    public String create(
            @RequestBody UserRequest request
    )
    {
        return "name=" + request.getName()
                + ", age=" + request.getAge();
    }

}
