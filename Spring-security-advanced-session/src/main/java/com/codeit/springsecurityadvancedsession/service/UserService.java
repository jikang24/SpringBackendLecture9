package com.codeit.springsecurityadvancedsession.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @PreAuthorize("hasRole('USER')")
  public String getUserData(){
    return """
        사용자 데이터 조회 성공
        """;
  }

}
