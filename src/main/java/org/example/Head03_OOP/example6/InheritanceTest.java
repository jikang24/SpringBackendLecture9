package org.example.Head03_OOP.example6;

public class InheritanceTest {
    public static void main(String[] args) {
        User u = new PersonalUser("U001", "Alice", "alice@example");
                u.printUserInfo();
        User b = new BusinessUser("U002", "Big show", "bigshow@example.com", "WWE");
                b.printUserInfo();
    }
}
