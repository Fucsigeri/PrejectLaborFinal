package com.users;

import com.advertisements.Advertisement;

import java.util.Arrays;

public class User{

    int userRole; // Munkavallalo-e vagy Munkaltato
    String username;
    String password;
    static int ID=0;

    @Override
    public String toString() {
        return "User{" +
                "userRole=" + userRole +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", advs=" + Arrays.toString(advs) +
                '}';
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        User.ID = ID;
    }

    Advertisement[] advs;

    public Advertisement[] getAdvs() {
        return advs;
    }

    public void setAdvs(Advertisement[] advs) {
        this.advs = advs;
    }


    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getUserRole() {
        return userRole;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User(int userRole, String username, String password) {
        this.userRole = userRole;
        this.username = username;
        this.password = password;
        ID++;
    }

    public void registration(String usrNm, String passwrd, int role){

    }


}
