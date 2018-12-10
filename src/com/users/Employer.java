package com.users;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Employer extends User {

    String companyName;
    String email;
    String location; // ceg helye

    public Employer(){}

    public Employer(int userRole, String username, String password, String companyName, String email, String location) {
        super(userRole, username, password);
        this.companyName = companyName;
        this.email = email;
        this.location = location;
    }

    public Employer(int id,int userRole, String username, String password, String companyName, String email, String location) {
        super(userRole, username, password);
        this.companyName = companyName;
        this.email = email;
        this.location = location;
        this.ID = id;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getEmail(){
        return email;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}'+super.toString();
    }

    public void registration() {
        Scanner input = new Scanner(System.in);
        int currId = userList.size();

        System.out.println("Username:");
        String usernm = input.nextLine();

        System.out.println("Password:");
        String passwrd = input.nextLine();

        System.out.println("What is your company's name?");
        String nm = input.nextLine();

        System.out.println("E-mail address: ");
        String mail = input.nextLine();

        System.out.println("Company's location: ");
        String loc = input.nextLine();

        userList.add(currId, new Employer(currId ,usernm, passwrd, nm, mail, loc));
    }
}
