package com.users;

import com.advertisements.Advertisement;

import java.util.Arrays;

public class User{

    int userRole; // Munkavallalo-e vagy Munkaltato
    String username;
    String password;
    int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID= " + ID + " " +
                "userRole=" + userRole +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", advs=" + Arrays.toString(advs) +
                '}' + "\n";
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
    }

    public User(int id,int userRole, String username, String password) {
        this.userRole = userRole;
        this.username = username;
        this.password = password;
        this.ID  = id;
    }

    public void registration(String usrNm, String passwrd, int role){

    }


}
