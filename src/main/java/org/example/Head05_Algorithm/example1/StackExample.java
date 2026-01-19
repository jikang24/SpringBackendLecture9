package org.example.Head05_Algorithm.example1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> oldStack = new Stack<>();
        // Stack 사용은 학습 용도
        oldStack.push(10);
        oldStack.push(20);
        oldStack.push(30);// 30 꺼냄
        System.out.println("[oldStack 결과");
        int firstPop = oldStack.pop();
        System.out.println("oldStack 첫번째 pop: " + firstPop);
        int secondPeek = oldStack.peek();// 확인만 하고 꺼내지 않음
        System.out.println("oldStack 두번째 peek: " + secondPeek);
        int secondPop = oldStack.pop();// 20 꺼냄
        System.out.println("oldStack 두번째 pop: " + secondPop);


        // 현대적 방식 - 권장되는 방식
        Deque<Integer> stackWithArrayDeque = new ArrayDeque<>();
        stackWithArrayDeque.push(10);// 앞에 추가
        stackWithArrayDeque.push(20);// 앞에 추가
        System.out.println("\n[stackWithArrayDeque 결과]");
        System.out.println("stackWithArrayDeque pop : "
                + stackWithArrayDeque.pop());// 출력: 20
        System.out.println("stackWithArrayDeaue 다음요소 peek : "
                + stackWithArrayDeque.peek());// 출력: 10
    }
}

// 실무 활용: 괄호 검사
// String expr = "((2+3)*4)";
// Deque<Character> stack = new ArrayDeque<>();
// for(char c : expr.toCharArray()) {
// 		if(c == '(') stack.push(c);
// 		if(c == ')') stack.pop();
// }
// boolean isValid = stack.isEmpty();
