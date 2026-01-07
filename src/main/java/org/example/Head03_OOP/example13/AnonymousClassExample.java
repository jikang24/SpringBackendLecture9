package org.example.Head03_OOP.example13;

public class AnonymousClassExample {
    public static void main(String[] args) {
        EventListener listener = new EventListener() {
            @Override
            public void onEvent(String eventData) {
                System.out.println("Event received: " + eventData);
            }
        };

        EventListener listener2 = new EventListener() {
            @Override
            public void onEvent(String eventData) {
                System.out.println("Event received2: " + eventData);
            }
        };

        simulateEvent("User_Login", listener);
        simulateEvent("User_Login", listener2);
    }

    public static void simulateEvent(String eventData, EventListener listener) {
        listener.onEvent(eventData);
    }
}
