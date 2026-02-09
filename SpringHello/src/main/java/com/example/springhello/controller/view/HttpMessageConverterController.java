package com.example.springhello.controller.view;

import com.example.springhello.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpMessageConverterController {
    @GetMapping(value = "/v1/members/json/{id}", produces = "application/json")
    @ResponseBody
    public MemberDTO getMemberJson(@PathVariable long id) {
        return new MemberDTO(id, "test@example.com", "홍길동", "010-1234-5678");
    }

}
