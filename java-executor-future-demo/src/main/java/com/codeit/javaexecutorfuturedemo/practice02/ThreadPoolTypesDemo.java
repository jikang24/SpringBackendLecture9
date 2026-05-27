package com.codeit.javaexecutorfuturedemo.practice02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTypesDemo {

  public static void run() {
    System.out.println();
    System.out.println("=== 2.6 [실습] 다양한 스레드 풀 유형 비교 ===");

    demonstrateSingleThreadExecutor();

    System.out.println();

    demonstrateFixedThreadPool();

    System.out.println();

    demonstrateCachedThreadPool();

  }

  private static void demonstrateSingleThreadExecutor() {

    System.out.println("[SingleThreadExecutor 테스트]");

    ExecutorService executorService =
        Executors.newSingleThreadExecutor();

    executeTasks(
        executorService,
        "Single"
    );
  }

  private static void demonstrateFixedThreadPool() {

    System.out.println("[FixedThreadPool 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(3);

    executeTasks(
        executorService,
        "Fixed"
    );
  }

  private static void demonstrateCachedThreadPool() {

    System.out.println("[CachedThreadPool 테스트]");

    ExecutorService executorService =
        Executors.newCachedThreadPool();

    executeTasks(
        executorService,
        "Cached"
    );
  }

  private static void executeTasks(
      ExecutorService executorService,
      String poolType
  ) {
    int taskCount = 10;

    long startTime = System.currentTimeMillis();

    for (int i = 0; i < taskCount; i++) {

      int taskId = i + 1;

      executorService.execute(() -> {

        String threadName =
            Thread.currentThread()
                .getName();

        System.out.println(
            "[" + poolType + "] "
                + threadName
                + " -> 작업 시작: task-"
                + taskId
        );

        try {
          Thread.sleep(1000);

        } catch (InterruptedException e) {

          Thread.currentThread()
              .interrupt();
        }

        System.out.println(
            "[" + poolType + "] "
                + threadName
                + " -> 작업 완료: task-"
                + taskId
        );
      });
  }
    executorService.shutdown();
    try {

      boolean terminated =
          executorService.awaitTermination(
              20,
              TimeUnit.SECONDS
          );

      if (!terminated) {

        executorService.shutdownNow();
      }

    } catch (InterruptedException e) {

      executorService.shutdownNow();

      Thread.currentThread()
          .interrupt();
    }

    long endTime =
        System.currentTimeMillis();

    System.out.println(
        "[" + poolType + "] 총 소요 시간: "
            + (endTime - startTime)
            + "ms"
    );
  }
}

