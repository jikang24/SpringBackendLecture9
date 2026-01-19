package org.example.Head05_Algorithm.example2;

public class Rectangle implements Shape{
    private int width;
    private int height;

    public Rectangle(double width, double height){
        this.width = (int)width;
        this.height = (int)height;
    }
    // Shape 인터페이스 구현
    public double getArea(){
        return width * height;
    }// 직사각형 넓이 = 가로 * 세로
}
