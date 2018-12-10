package com.users;

import com.company.Main;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User {

    public Admin(int userRole, String username, String password) {
        super(userRole=3, username="admin", password="admin");
    }
    public Admin(){}

    public List deleteUser(List list) {
        Scanner input = new Scanner(System.in);

        for (int i=1; i< list.size(); i++){
            System.out.print(i + " ");
            System.out.println(list.get(i));
        }
        System.out.println("Which user do you like to delete?");
        int choice = input.nextInt();
        list.remove(choice);
        return list;
    }
}
