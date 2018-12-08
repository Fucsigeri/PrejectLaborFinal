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

    public String getName(){
        return name;
    }

    public int getAge(){
        return Age;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                ", phoneNumber=" + phoneNumber +
                '}'+super.toString();
    }
}
