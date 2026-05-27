package com.codeit.javacompletablefuturedemo.practice02;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureCombinationDemo {

  public static void run(){

    System.out.println();
    System.out.println("=== 2.4 [실습] 비동기 작업 조합 패턴 ===");

    demonstrateThenCompose();

    System.out.println();

    demonstrateThenCombine();

    System.out.println();

    demonstrateAllOf();

    System.out.println();

    demonstrateAnyOf();
  }

  private static void demonstrateThenCompose(){

    System.out.println("[thenCompose 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(3);

    CompletableFuture<String> signupFuture =
        createUserId(executorService)

            .thenCompose(userId ->
                createProfile(userId, executorService))

            .thenCompose(profileId ->
                sendWelcomeEmail(profileId, executorService));


    String result = signupFuture.join();

    System.out.println(
        now() + " [main] 최종 결과: " + result
    );

    executorService.shutdown();
  }

  private static void demonstrateThenCombine() {

    System.out.println("[thenCombine 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(2);

    CompletableFuture<Integer> priceFuture =
        CompletableFuture.supplyAsync(() -> {
          System.out.println(
              now() + " [price] 상품 가격 조회 시작"
          );

          sleep(2000);

          System.out.println(
              now() + " [price] 상품 가격 조회 완료"
          );

          return 10000;

        }, executorService);

    CompletableFuture<Integer> discountFuture =
        CompletableFuture.supplyAsync(() -> {
          System.out.println(
              now() + " [discount] 할인 금액 조회 시작"
          );

          sleep(1500);

          System.out.println(
              now() + " [discount] 할인 금액 조회 완료"
          );

          return 2000;
        }, executorService);

    Integer finalPrice = priceFuture.thenCombine(
        discountFuture, (price, discount) -> price - discount).join();

    System.out.println(
        now() + " [main] 최종 결제 금액: " + finalPrice
    );

    executorService.shutdown();
  }

  private static void demonstrateAllOf() {


    System.out.println("[allOf 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(3);

    CompletableFuture<String> imageFuture =
        loadProductImage(executorService);

    CompletableFuture<String> descriptionFuture =
        loadProductDescription(executorService);

    CompletableFuture<String> reviewFuture =
        loadProductReviews(executorService);

    CompletableFuture<Void> allFuture =
        CompletableFuture.allOf(imageFuture, descriptionFuture, reviewFuture);

    allFuture.join();

    System.out.println(
        now() + " [main] 상품 상세 데이터 통합"
    );

    // 이미 allOf()로 완료된 상태이므로 즉시 결과 반환
    System.out.println("이미지: " + imageFuture.join());
    System.out.println("설명: " + descriptionFuture.join());
    System.out.println("리뷰: " + reviewFuture.join());

    executorService.shutdown();
  }

  private static void demonstrateAnyOf() {

    System.out.println("[anyOf 테스트]");

    ExecutorService executorService =
        Executors.newFixedThreadPool(3);

    // 여러 업체에 동시에 견적 요청
    List<CompletableFuture<String>> futures =
        List.of(
            requestVendor("업체A", 3000, executorService),
            requestVendor("업체B", 1000, executorService),
            requestVendor("업체C", 2000, executorService)
        );

    // 가장 먼저 끝난 작업 결과만 사용
    Object fastestResult =
        CompletableFuture.anyOf(
            futures.toArray(new CompletableFuture[0])
        ).join();

    System.out.println(
        now() + " [main] 가장 빠른 견적: "
            + fastestResult
    );

    // 나머지 작업은 굳이 기다릴 필요 없으므로 종료 시도
    executorService.shutdownNow();
  }

  private static CompletableFuture<String> createUserId(
      ExecutorService executorService
  ) {

    return CompletableFuture.supplyAsync(() -> {

      System.out.println(
          now() + " [signup] 사용자 ID 생성 시작"
      );

      sleep(1000);

      System.out.println(
          now() + " [signup] 사용자 ID 생성 완료"
      );

      return "USER-100";

    }, executorService);
  }

  private static CompletableFuture<String> createProfile(
      String userId,
      ExecutorService executorService
  ) {

    return CompletableFuture.supplyAsync(() -> {

      System.out.println(
          now() + " [profile] 프로필 생성 시작: " + userId
      );

      sleep(1000);

      System.out.println(
          now() + " [profile] 프로필 생성 완료"
      );

      return "PROFILE-" + userId;

    }, executorService);
  }

  private static CompletableFuture<String> sendWelcomeEmail(
      String profileId,
      ExecutorService executorService
  ) {

    return CompletableFuture.supplyAsync(() -> {

      System.out.println(
          now() + " [email] 환영 이메일 발송 시작: " + profileId
      );

      sleep(1000);

      System.out.println(
          now() + " [email] 환영 이메일 발송 완료"
      );

      return "회원가입 완료";

    }, executorService);
  }

  private static CompletableFuture<String> loadProductImage(
      ExecutorService executorService
  ) {

    return CompletableFuture.supplyAsync(() -> {

      System.out.println(
          now() + " [image] 상품 이미지 조회 시작"
      );

      sleep(1000);

      System.out.println(
          now() + " [image] 상품 이미지 조회 완료"
      );

      return "product-image.png";

    }, executorService);
  }

  private static CompletableFuture<String> loadProductDescription(
      ExecutorService executorService
  ) {

    return CompletableFuture.supplyAsync(() -> {

      System.out.println(
          now() + " [description] 상품 설명 조회 시작"
      );

      sleep(1500);

      System.out.println(
          now() + " [description] 상품 설명 조회 완료"
      );

      return "상품 설명 데이터";

    }, executorService);
  }

  private static CompletableFuture<String> loadProductReviews(
      ExecutorService executorService
  ) {

    return CompletableFuture.supplyAsync(() -> {

      System.out.println(
          now() + " [review] 리뷰 조회 시작"
      );

      sleep(2000);

      System.out.println(
          now() + " [review] 리뷰 조회 완료"
      );

      return "리뷰 128개";

    }, executorService);
  }

  private static CompletableFuture<String> requestVendor(
      String vendorName,
      int delayMillis,
      ExecutorService executorService
  ) {

    return CompletableFuture.supplyAsync(() -> {

      System.out.println(
          now() + " [" + vendorName + "] 견적 요청 시작"
      );

      sleep(delayMillis);

      System.out.println(
          now() + " [" + vendorName + "] 견적 응답 완료"
      );

      return vendorName + " 견적: 352,000원";

    }, executorService);
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
