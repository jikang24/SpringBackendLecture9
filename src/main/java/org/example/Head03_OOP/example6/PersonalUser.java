package org.example.Head03_OOP.example6;

public class PersonalUser extends User {
    private String email;

    public PersonalUser(String id, String name, String email){
        super(id, name);
        this.email = email;
    }

    @Override
    public void printUserInfo() {
        super.printUserInfo();
        System.out.println("이메일: " + email);
    }

}
