package com.users;

public class Employer extends User {
    String companyName;
    String email;
    String location; // ceg helye

    public Employer(int userRole, String username, String password, String companyName, String email, String location) {
        super(userRole, username, password);
        this.companyName = companyName;
        this.email = email;
        this.location = location;
    }
}
