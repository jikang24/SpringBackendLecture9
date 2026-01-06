package org.example.Head03_OOP.example2;

public class Product {
    private String productId;
    private String name;
    private double price;

    // 생성자
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Getter 메서드
}
