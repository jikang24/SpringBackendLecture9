package org.example.Head05_Algorithm.example1;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("apple");// 해시값 계산 -> 저장
        set.add("banana");// 다른 위치에 저장
        set.add("apple");// 중복 무시

        System.out.println(set.contains("banana"));

        System.out.println(set.size());
    }
}


// 방문자 중복 체크
// Set<String> visitors = new HashSet<>();
// if(!visitors.contains(userId)) {
// 		visitors.add(userId);
// 		incrementVisitorCount();
// }