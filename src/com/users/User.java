package com.users;

import com.advertisements.Advertisement;
import com.advertisements.FileManagger;

import java.util.*;

public class User{


    public List<User> userList = new LinkedList<>();

    private int userRole; // Munkavallalo-e vagy Munkaltato
    private String username;
    private String password;
    int ID;

    public User(){} // Main miatt

    public User(int userRole, String username, String password) {
        this.userRole = userRole;
        this.username = username;
        this.password = password;
    }

    public User(int id,int userRole, String username, String password) { // fajlbol kiolvasas miatt
        this.userRole = userRole;
        this.username = username;
        this.password = password;
        this.ID  = id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "User{" +
                "ID= " + ID + " " +
                "userRole=" + userRole +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", advs=" +
                '}' + "\n";
    }

}
