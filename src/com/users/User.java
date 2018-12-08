package com.users;

public class User{

    int userRole; // Munkavallalo-e vagy Munkaltato
    String username;
    String password;

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

    public void registration(String usrNm, String passwrd, int role){

    }

    @Override
    public String toString() {
        return "User{" +
                "userRole=" + userRole +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
