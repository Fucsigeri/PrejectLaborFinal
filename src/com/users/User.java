package com.users;

public class User implements Users {

    int userRole; // Munkavallalo-e vagy Munkaltato
    String username;
    String password;



    public User(int userRole, String username, String password) {
        this.userRole = userRole;
        this.username = username;
        this.password = password;
    }

    public void registration(String usrNm, String passwrd, int role){

    }
}
