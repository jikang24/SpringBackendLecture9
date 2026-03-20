package com.example.springtdd.Head02_JUnitBasic.example2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

  private UserService userService;

  @BeforeEach
  void setUp() {
    System.out.println("beforeEach 실행");
    userService = new UserService();
  }

  @AfterEach
  void tearDown(){
    System.out.println("AfterEach 실행");
  }

  @Test
  void createUser_shouldReturnName(){
    String result = userService.create("kim");

    //일부러 틀린값 확인
    assertEquals("gim", result);
    System.out.println("createUser_shouldReturnName 실행");
  }

  @Test
  void createUser_shouldReturnNull(){
    String result = userService.create("lee");

    assertNotNull(result);
    System.out.println("createUser_shouldNotReturnNull 실행");
  }

}
