package com.codeit.springsecurityadvancedsession.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
  @PreAuthorize("hasRole('ADMIN')")
  public String getAdminData() {
    return """
        관리자 전용 데이터 조회 성공
        """;
  }

}
