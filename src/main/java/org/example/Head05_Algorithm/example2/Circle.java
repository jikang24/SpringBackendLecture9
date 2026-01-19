package org.example.Head05_Algorithm.example2;

// 도형 구현 클래스 - 원
public class Circle implements Shape{
    private double radius;
    public Circle(double radius) { this.radius = radius; }

    // Shape의 인터페이스 getArea() 구현
    public double getArea() {
        return Math.PI * radius * radius; }// 원의 넓이 구하기
}
