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
    Advertisement advertisement = new Advertisement();
    User user = new User();
    Employer employer = new Employer();
    Employee employee = new Employee();

    public static void main(String[] args) {
        new Main().init();
    }

    private void init() {
        advertisement.adList = FileManagger.getAdvertisements();
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
            }while(choice!=5);
        }catch(Exception ex){
            System.out.println("Something went wrong! Please try again.");
            init();
        }
    }

    private void printRegisterMenuForEmployer(){
        System.out.println("Create an Employer account:");
        Employer er = (Employer) employer.registration();
        userList.add(er);
        er.setID(userList.size());
    }


    private void printRegisterMenuForEmployee(){
        System.out.println("Create an Employee account:");
        Employee ee = (Employee) employee.registration();
        userList.add(ee);
        ee.setID(userList.size());
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
                        startSessionForAdmin();
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
        do{
            System.out.println("1. New advertisement");
            System.out.println("2. Modify advertisement");
            System.out.println("3. Delete advertisement");
            System.out.println("4. List advertisements");
            System.out.println("5. Log out");
            choice = input.nextInt();
            switch(choice){
                case 1:
                    advertisement.newAd();
                    break;
                case 2:
                    advertisement.modifyAd();
                    break;
                case 3:
                    advertisement.deleteAd();
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
        System.out.println("3. Sign in");
        System.out.println("5. Exit");
    }
}
