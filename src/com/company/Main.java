package com.company;

import com.advertisements.Advertisement;
import com.advertisements.FileManagger;
import com.users.Employee;
import com.users.Employer;
import com.users.User;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<User> userList = FileManagger.getUsers();

    public static void main(String[] args) {
        new Main().init();
    }

    private void init() {
        Advertisement advertisement = new Advertisement();
        showMenu();
        FileManagger.saveUsers(userList);
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
                        System.out.println(userList);
                        printRegisterMenuForEmployee();
                        Employee ee = (Employee) createEmployee();
                        userList.add(ee);
                        ee.setID(userList.size());
                        System.out.println(ee.getUserRole());
                        System.out.println("Added?");
                        System.out.println(userList.get(0).toString());
                        FileManagger.saveUsers(userList);
                        break;
                    case 2:
                        printRegisterMenuForEmployer();
                        Employer er = (Employer) createEmployer();
                        userList.add(er);
                        er.setID(userList.size());
                        FileManagger.saveUsers(userList);
                        System.out.println(er.getID());
                        System.out.println(userList.get(0).toString()
                        );
                        break;
                    case 3:
                        choice = validationLoginEmployee();
                        break;
                    case 4:
                        choice = validationLoginEmployer();
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
        return new Employer(2,userName,password,companyName,email,location);
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
        return new Employee(1,userName,password,name,age,phoneNumber);
    }

    private int validationLoginEmployee(){
        int succesfull_login = 5;
        int unsuccesfull_login = 2;
        Scanner input = new Scanner(System.in);
        String i_userName,i_password;
        System.out.println("Please enter your Username");
        i_userName =  input.nextLine();
        Iterator it = userList.iterator();
        int i = 0;
        while(it.hasNext()){
            if(userList.get(i).getUsername().equalsIgnoreCase(i_userName)){
                System.out.println("Please enter your password");
                i_password = input.nextLine();
                if(userList.get(i).getPassword().equals(i_password)){
                    startSessionForEmployee();
                    return succesfull_login;                        // kilepesi ertek a fomenubol
                } else {
                    return unsuccesfull_login;
                }
            }
            i++;
        }
        System.out.println("Nem lep be ide");
        return unsuccesfull_login;
    } // ha sikeresen bejelentkezett indul egy uj session ahol csak szemelyre szabottan o lajta a dolgokat



    private int validationLoginEmployer(){
        int succesfull_login = 5;
        int unsuccesfull_login = 2;
        Scanner input = new Scanner(System.in);
        String i_userName,i_password;
        System.out.println("Please enter your Username");
        i_userName =  input.nextLine();
        System.out.println(userList.get(0).getUsername());
        Iterator it = userList.iterator();
        while(it.hasNext()){
            if(userList.get(0).getUsername().equalsIgnoreCase(i_userName)){
                System.out.println("Please enter your password");
                i_password = input.nextLine();
                if(userList.get(0).getPassword().equals(i_password)){
                    startSessionForEmployee();
                    return succesfull_login;                                       // kilepesi ertek a fomenubol
                } else {
                    return unsuccesfull_login;
                }
            }
        }
        System.out.println("Nem lep be ide");
        return unsuccesfull_login;
    } // same

    private void startSessionForEmployee(){
        System.out.println("you started a session as employee");
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            printMenu();
            choice = input.nextInt();
            switch(choice){
                case 1:
                    //addNewAdvertisment();
                    break;
                case 2:
                    //listAdvertisment();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Wrong menu item");
                    break;
            }
        }while(choice!=5);

    }

    private void startSessionForEmployer(){
        System.out.println("you started a session as employer");

    }
    private void startSessionForAdmin(){
        System.out.println("you started a session as admin");

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
