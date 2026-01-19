package org.example.Head05_Algorithm.example3;

public class GenericMethodExample {
    // U는 Comparable 을 구현한 타입만 가능 -> 비교할 수 있어야 최대값을 구할 수 있기 때문
    public static <U extends Comparable<U>> U max(U a, U b){
        // Comparable 덕분에 compareTo 사용 가능
        if (a.compareTo(b) >= 0) {
            return a;
        }else{
            return b;
        }
    }

    public static void main(String[] args) {
    // 컴파일러가 자동으로 타입 결정 -> 타입 추론
        System.out.println( max(10, 20));    // 20 (Integer)
        System.out.println( max("apple", "pear"));// pear (String)
        System.out.println(GenericMethodExample.<Integer>max(10, 20));
    }
}
