package org.example.Head03_OOP.example4;
//(암묵적 우선순위 이슈) 가변인자를 사용할 때는
// 파라미터 해석의 우선순위나 오버로딩 시 혼동이 생기지 않도록 주의해야 한다.
public class VarargsExample {
    public static void main(String[] args) {
        Example ex = new Example();
        ex.print(1, 2);  // fixed two ints 호출
    }
}

class Example {
    void print(int a, int b) { System.out.println("fixed two ints"); }
    void print(int... nums) { System.out.println("varargs ints"); }
}

