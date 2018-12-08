package com.company;

import com.advertisements.Advertisement;
import com.users.Employee;
import com.users.Employer;
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
        System.out.println("Welcome in our application");
        System.out.println("Please choose a menu point:");
        try{
            do{
                printMenu();
                choice = input.nextInt();
                switch(choice){
                    case 1:
                        printRegisterMenuForEmployee();
                        Employee ee = (Employee) createEmployee();
                        System.out.println("asd");
                        userList.add(ee);
                        System.out.println("Added?");
                        System.out.println(
                                userList.get(0).toString()
                        );
                        break;
                    case 2:
                        printRegisterMenuForEmployer();
                        Employer er = (Employer) createEmployer();
                        userList.add(er);
                        System.out.println(userList.get(0).toString()
                        );
                        break;
                    case 3:
                        choice = validationLoginEmployee();

                        break;
                    case 4:
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("Wrong menu item");
                        break;
                }
            }while(choice!=5);
        }catch(Exception ex){
            System.out.println("Wrong menu item");
            init();
        }
    }

    private void printRegisterMenuForEmployer(){
        System.out.println("Create an Employer account:");
    }
    private User createEmployer(){
        Scanner input = new Scanner(System.in);
        String userName,password,companyName,email,location;
        int userRole;
        userName = input.nextLine();
        password = input.nextLine();
        companyName = input.nextLine();
        email = input.nextLine();
        location = input.nextLine();
        return new Employer(1,userName,password,companyName,email,location);
    }


    private void printRegisterMenuForEmployee(){
        System.out.println("Create an Employee account:");
    }
    private Employee createEmployee(){
        Scanner input = new Scanner(System.in);
        String userName, password,name;
        int age,phoneNumber;
        userName = input.nextLine();
        password = input.nextLine();
        name = input.nextLine();
        age = Integer.parseInt(input.nextLine());
        phoneNumber = Integer.parseInt(input.nextLine());
        return new Employee(2,userName,password,name,age,phoneNumber);
    }

    private int validationLoginEmployee(){
        int succesfull_login = 5;
        int unsuccesfull_login = 2;
        Scanner input = new Scanner(System.in);
        String i_userName,i_password;
        System.out.println("Please enter your Username");
        i_userName =  input.nextLine();
        Object[] userArray= userList.toArray();
        for(int i = 0; userArray.length > i; i++){
            if(userList.get(i).getUsername() == i_userName){
                System.out.println("Please enter your password");
                i_password = input.nextLine();
                if(userList.get(i).getPassword() == i_password){
                    startSessionForEmployee();
                    return succesfull_login;                                       // kilepesi ertek a fomenubol
                } else {
                    return unsuccesfull_login;
                }
            }
        }
        System.out.println("Nem lep be ide");
        return unsuccesfull_login;
    } // ha sikeresen bejelentkezett indul egy uj session ahol csak szemelyre szabottan o lajta a dolgokat
    private void validationLoginEmployer(){} // same
    private void printEmployeeMenu(){}
    private void printEmployerMenu(){}


    private void startSessionForEmployee(){
        System.out.println("you started a session as employee");
    }


    private void deleteUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number you want to delete");
        Object[] userArray= userList.toArray();
        int index = input.nextInt();
        if(index>userArray.length || index<userArray.length){
            System.out.println("There is no index like that!");
        } else {
            userList.remove(index-1);
        }
    }

    private void printMenu() {
        System.out.println("1. Register as Employee");
        System.out.println("2. Register as Employer");
        System.out.println("3. Sign in as Employee");
        System.out.println("4. Sign in as Employer");
        System.out.println("5. Exit");
    }
}
