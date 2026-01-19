package org.example.Head05_Algorithm.example1;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        // 양방향 큐 생성
        Deque<Integer> deque = new ArrayDeque<>();
        // 앞쪽에 추가
        deque.addFirst(1);
        // 뒤쪽에 추가
        deque.addLast(2);
        deque.addLast(5);
        deque.addLast(3);
        deque.addFirst(0);

        // 양쪽에서 제거
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());

        //[0,1,2,5,3]

        // 최근 N개 항목 유지
    // Deque<String> recentItems = new LinkedList<>();
    //  recentItems.addFirst(newItem);
    // if(recentItems.size() > 10) {
    // 		recentItems.removeLast(); // 오래된 것 제거
    // }
    }
}
