package com.codeit.springhttpsdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @GetMapping("/api/health")
  public Map<String,Object> health(
      HttpServletRequest request
  ) {
    return Map.of("status", "UP",
        "secure", request.isSecure(),
        "schema", request.getScheme(),
        "serverPort", request.getServerPort()
    );
  }

}
