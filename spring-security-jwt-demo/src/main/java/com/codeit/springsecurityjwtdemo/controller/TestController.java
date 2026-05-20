package com.codeit.springsecurityjwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/api/hello")
  public String hello() {
    return "Hello";
  }

  @GetMapping("api/auth/login")
  public String login() {
    return "Login page";
  }
}
