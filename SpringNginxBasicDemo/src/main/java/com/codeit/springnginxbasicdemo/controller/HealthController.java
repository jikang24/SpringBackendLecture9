package com.codeit.springnginxbasicdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

  @Value("${INSTANCE_NAME:unknown}")
  private String instanceName;

  @Value("${server.port:8080}")
  private int serverPort;

  @GetMapping("/api/health")
  public Map<String, Object> health(HttpServletRequest request) {
    return Map.of("status", "UP",
        "instance", instanceName,
        "host", request.getServerName(),
        "serverPort", serverPort,
        "xForwardedProto", getHeader(request,"X-Forwarded-Proto"),
        "xForwardedFor", getHeader(request,"X-Forwarded-For"),
        "xRealIp", getHeader(request,"X-Real-IP")
    );
  }

  private String getHeader(HttpServletRequest request, String headerName) {
    String value = request.getHeader(headerName);
    if (value == null || value.isBlank()) {
      return "not set";
    }
    return value;
  }

}
