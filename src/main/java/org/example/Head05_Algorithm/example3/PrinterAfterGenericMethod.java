package org.example.Head05_Algorithm.example3;

import java.util.List;
import java.util.function.Function;

public class PrinterAfterGenericMethod {
    // 제네릭 메서드: 모든 타입 T에 대해 동작
    // Function<T, String>: T를 String으로 변환하는 함수
    public static <T> void printList(
            List<T> list,
            Function<T, String> formatter){
        // formatter를 통해 각 타입별 출력 형식 결정
        for (T item : list) {
            System.out.println(formatter.apply(item));
        }
    }
}
