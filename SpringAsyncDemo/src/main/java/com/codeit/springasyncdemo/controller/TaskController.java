package com.codeit.springasyncdemo.controller;

import com.codeit.springasyncdemo.service.TaskService;
import java.time.LocalTime;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @GetMapping("/api/tasks/start")
  public Map<String, Object> startTask() {
    String threadName = Thread.currentThread().getName();

    System.out.println(now() + " [TaskController] 요청 수신");
    System.out.println(now() + " [TaskController] 요청 처리 스레드: " + threadName);

    taskService.sendExternalApiTask();
    taskService.calculateReportTask();

    System.out.println(now() + " [TaskController] 응답 반환");

    return Map.of(
        "success", true,
        "message", "작업 유형별 비동기 작업 실행 요청 완료",
        "requestThread", threadName
    );
  }
  private String now() {
    return "[" + LocalTime.now().withNano(0) + "]";
  }

}
