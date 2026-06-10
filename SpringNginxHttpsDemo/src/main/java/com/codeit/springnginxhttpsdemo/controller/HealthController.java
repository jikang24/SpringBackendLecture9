package com.codeit.springnginxhttpsdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @GetMapping("/api/health")
  public Map<String, Object> health(
      HttpServletRequest request
  ) {
    return Map.of("status", "UP",
        "requestSecure", request.isSecure(),
        "requestScheme", request.getScheme(),
        "serverPort", request.getServerPort(),
        "host", getHeader(request, "Host"),
        "xForwardedProto", getHeader(request, "X-Forwarded-Proto"),
        "xForwardedFor", getHeader(request, "X-Forwarded-For"),
        "xRealIp", getHeader(request, "X-Real-IP")
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
