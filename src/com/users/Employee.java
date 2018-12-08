package com.users;

public class Employee extends User {
    String name;
    int  Age;
    int phoneNumber;

    public Employee(int userRole, String username, String password, String name, int age, int phoneNumber) {
        super(userRole, username, password);
        this.name = name;
        Age = age;
        this.phoneNumber = phoneNumber;
    }
}
