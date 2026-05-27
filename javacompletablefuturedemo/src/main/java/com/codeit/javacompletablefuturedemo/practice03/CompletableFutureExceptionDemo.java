package com.codeit.javacompletablefuturedemo.practice03;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExceptionDemo {

  public static void run() {

    System.out.println();
    System.out.println("=== 3.5 [실습] CompletableFuture 예외 처리와 회복 ===");

    demonstrateExceptionally();

    System.out.println();

    demonstrateHandle();

    System.out.println();

    demonstrateWhenComplete();
  }

  private static void demonstrateExceptionally(){

    System.out.println("[exceptionally 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(2);

    CompletableFuture<String> paymentFuture =
        CompletableFuture
            .supplyAsync(() -> {

              System.out.println(
                  now() + " [payment] 결제 API 호출 시작"
              );

              sleep(1000);

              if (true) {
                throw new RuntimeException("결제 서버 응답 지연");
              }

              return "결제 완료";


            }, executorService)

            .exceptionally(exception -> {
              System.out.println(
                  now() + " [exceptionally] 예외 복구: "
                      + exception.getMessage()
              );

              return "결제 시스템 점검 중입니다.";

            });

    String result = paymentFuture.join();


    System.out.println(
        now() + " [main] 최종 결과: " + result
    );

    executorService.shutdown();
  }

  private static void demonstrateHandle(){

    System.out.println("[handle 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(2);

    CompletableFuture<String> resultFuture =
        CompletableFuture
            .supplyAsync(() -> {
              System.out.println(
                  now() + " [order] 주문 처리 시작"
              );

              sleep(1000);

              return "ORDER-100";
            }, executorService)

            .handle((result, exeption) -> {

              if (exeption != null){

                System.out.println(
                    now() + " [handle] 주문 실패 처리"
                );

                return "주문 실패: 다시 시도해주세요.";

              }
              System.out.println(
                  now() + " [handle] 주문 성공 처리: "
                      + result
              );

              return "주문 성공: " + result;
            });
    System.out.println(
        now() + " [main] 최종 결과: "
            + resultFuture.join()
    );

    executorService.shutdown();
  }

  private static void demonstrateWhenComplete(){

    System.out.println("[whenComplete 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(2);

    CompletableFuture<String> deliveryFuture =
        CompletableFuture
            .supplyAsync(() -> {

              System.out.println(
                  now() + " [delivery] 배송 정보 생성 시작"
              );

              sleep(1000);

              return "DELIVERY-500";

            }, executorService)
            .whenComplete((result, exception) -> {
              if (exception != null){
                System.out.println(
                    now() + " [whenComplete] 실패 로그 기록: "
                        + exception.getMessage()
                );
              }else {
                System.out.println(
                  now() + " [whenComplete] 성공 로그 기록: "
                      + result
              );

              }
            });

    String result = deliveryFuture.join();
    System.out.println(
        now() + " [main] 최종 결과: " + result
    );

    executorService.shutdown();

  }
  private static void sleep(long millis) {

    try {

      Thread.sleep(millis);

    } catch (InterruptedException e) {

      Thread.currentThread().interrupt();
    }
  }

  private static String now() {

    return "[" + LocalTime.now().withNano(0) + "]";
  }


}
