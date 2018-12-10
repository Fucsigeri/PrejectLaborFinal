package com.company;

import com.advertisements.Advertisement;
import com.advertisements.FileManagger;
import com.users.Admin;
import com.users.Employee;
import com.users.Employer;
import com.users.User;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<User> userList;
    Advertisement advertisement = new Advertisement();
    Employer employer = new Employer();
    Employee employee = new Employee();
    Admin admin = new Admin();

    public static void main(String[] args) {
        new Main().init();
    }

    private void init() {
        advertisement.adList = FileManagger.getAdvertisements();
        userList =  FileManagger.getUsers();

        showMenu();
        FileManagger.saveAdvertisements(advertisement.adList);
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
                        printRegisterMenuForEmployee();
                        break;
                    case 2:
                        printRegisterMenuForEmployer();
                        break;
                    case 3:
                        choice = userLoginValidation();
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
            System.out.println("Something went wrong! Please try again.");
            init();
        }
    }

    private void printRegisterMenuForEmployer(){
        System.out.println("Create an Employer account:");
        Employer er = (Employer) employer.registration();
        er.setID(userList.size());
        userList.add(er);
        FileManagger.saveUsers(userList);
    }


    private void printRegisterMenuForEmployee(){
        System.out.println("Create an Employee account:");
        Employee ee = (Employee) employee.registration();
        ee.setID(userList.size());
        userList.add(ee);
        FileManagger.saveUsers(userList);
    }

    private int userLoginValidation(){
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
                    if(userList.get(i).getUserRole() == 1) {
                        startSession(i_userName,userList.get(i).getUserRole());
                    } else if(userList.get(i).getUserRole() == 2){
                        startSession(i_userName,userList.get(i).getUserRole());
                    } else if(userList.get(i).getUserRole() == 3){
                        startSession(i_userName,userList.get(i).getUserRole());
                    }
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


    private void startSession(String usrnm, int roleid){
        String roleString="";
        switch (roleid){
            case 1:
                roleString=" Employee";
                break;
            case 2:
                roleString=" Employer";
                break;
            case 3:
                roleString=" Admin";
                break;
            default:
                break;
        }
        System.out.println(usrnm + " started a session as" + roleString);
        Scanner input = new Scanner(System.in);
        int choice;
        if (roleid < 3) {
            do {
                System.out.println("1. New advertisement");
                System.out.println("2. Modify advertisement");
                System.out.println("3. Delete advertisement");
                System.out.println("4. List advertisements");
                System.out.println("5. Log out");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        advertisement.newAd();
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 2:
                        advertisement.modifyAd();
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 3:
                        advertisement.deleteAd();
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 4:
                        advertisement.listAds();
                        break;
                    case 5:
                        init();
                        break;
                    default:
                        System.out.println("Wrong menu item");
                        break;
                }
            } while (choice != 5);
        } else {
            do {
                System.out.println("1. New advertisement");
                System.out.println("2. Modify advertisement");
                System.out.println("3. Delete advertisement");
                System.out.println("4. List advertisements");
                System.out.println("5. Delete user");
                System.out.println("6. Log out");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        advertisement.newAd();
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 2:
                        advertisement.modifyAd();
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 3:
                        advertisement.deleteAd();
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 4:
                        advertisement.listAds();
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 5:
                        admin.deleteUser(userList);
                        FileManagger.saveAdvertisements(advertisement.adList);
                        break;
                    case 6:
                        System.out.println("Logging out....");
                        break;
                    default:
                        System.out.println("Wrong menu item");
                        break;
                }
            } while (choice != 6);
        }
    }


    private void startSessionForAdmin(){
        System.out.println("you started a session as admin");

    }

    private void printMenu() {
        System.out.println("1. Register as Employee");
        System.out.println("2. Register as Employer");
        System.out.println("3. Sign in");
        System.out.println("4. Exit");
    }
}
