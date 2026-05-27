package com.codeit.springasyncdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequiredArgsConstructor
public class AsyncMonitorController {

  private final ThreadPoolTaskExecutor myTaskExecutor;
  private final ThreadPoolTaskExecutor cpuTaskExecutor;
  private final ThreadPoolTaskExecutor ioTaskExecutor;

  @GetMapping("/api/async/executors")
  public Map<String, Object> getExecutorsStatus() {

    return Map.of(
        "myTaskExecutor", getExecutorsStatus(myTaskExecutor),
        "ioTaskExecutor", getExecutorsStatus(ioTaskExecutor),
        "cpuTaskExecutor", getExecutorsStatus(cpuTaskExecutor)
    );
  }

  private Map<String, Object> getExecutorsStatus(ThreadPoolTaskExecutor executor) {

    ThreadPoolExecutor threadPoolExecutor = executor.getThreadPoolExecutor();

    return Map.of(
        "corePoolSize", threadPoolExecutor.getCorePoolSize(),
        "maximumPoolSize", threadPoolExecutor.getMaximumPoolSize(),
        "poolSize", threadPoolExecutor.getPoolSize(),
        "activeCount", threadPoolExecutor.getActiveCount(),
        "queueSize", threadPoolExecutor.getQueue().size(),
        "completedTaskCount", threadPoolExecutor.getCompletedTaskCount()
    );
  }

}
