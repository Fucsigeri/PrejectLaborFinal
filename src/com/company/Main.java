package com.company;

import com.advertisements.Advertisement;
import com.users.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<User> userList = new LinkedList<>();
    List<Advertisement> adList = new LinkedList<>();

    public static void main(String[] args) {
        new Main().init();
    }

    private void init() {
        showMenu();
    }

    private void showMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        try{
            do{
                printMenu();
                choice = input.nextInt();
                switch(choice){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("Wrong menu item");
                        break;
                }
            }while(choice!=4);
        }catch(Exception ex){
            System.out.println("Wrong menu item");
            init();
        }
    }

    private void printMenu() {
        System.out.println("Welcome in our application");
        System.out.println("Please choose a menu point:");
        System.out.println("1. Registration");
        System.out.println("2. Sign in");
        System.out.println("3. List our advertisements");
        System.out.println("4. Exit");
    }
}
