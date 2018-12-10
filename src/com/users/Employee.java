package com.users;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Employee extends User {

    String name;
    int age;
    int phoneNumber;

    public  Employee(){}

    public Employee(int id, int userRole, String username, String password, String name, int age, int phoneNumber) {
        super(id,userRole, username, password);
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Employee(int userRole, String username, String password, String name, int age, int phoneNumber) {
        super(userRole, username, password);
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                '}'+super.toString();
    }

    public void registration() {
        Scanner input = new Scanner(System.in);
        int currId = userList.size();

        System.out.println("Username:");
        String usernm = input.nextLine();

        System.out.println("Password:");
        String passwrd = input.nextLine();

        System.out.println("What is your name?");
        String nm = input.nextLine();

        System.out.println("How old are you?");
        int age = input.nextInt();

        System.out.println("Your phone number:");
        int phnNumber = input.nextInt();

        userList.add(currId, new Employee(currId ,usernm, passwrd, nm, age, phnNumber));
    }
}
