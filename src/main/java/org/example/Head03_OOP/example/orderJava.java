package org.example.Head03_OOP.example;

public class orderJava {
    private String orderId;
    private boolean isPaid;
    private String customerName;

    public orderJava(){
        this.orderId = "None";
        this.isPaid = false;

    }

    public orderJava(String orderId, boolean isPaid){
        this.orderId = orderId;
        this.isPaid = isPaid;
    }
    //getter or setter 생성 법 실습

    public String getOrderId(){
        return this.orderId;
    }

    public boolean getIsPaid(){
        return this.isPaid;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }
}
