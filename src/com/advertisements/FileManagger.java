package com.advertisements;

import com.users.Admin;
import com.users.Employee;
import com.users.Employer;
import com.users.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileManagger {
    private static StringBuffer stringBufferOfData = new StringBuffer();

    public static void saveAdvertisements(List<Advertisement> aList) {
        Advertisement[] array = new Advertisement[aList.size()];
        array = aList.toArray(array);

        String writeString = "";
        for (int i = 0; i < aList.size(); i++) {
            writeString += array[i].getId() + ";";
            writeString += array[i].getTitle() + ";";
            writeString += array[i].getDetails() + ";";
            writeString += "\n";
        }
        writeToFile(writeString,"Advertisements");
    }

    public static List<Advertisement> getAdvertisements() {
        List<String> list = readFile("Advertisements");
        List<Advertisement> aList = new LinkedList<>();
        String[] array = new String[list.size()];
        array = list.toArray(array);

        for (int i = 0; i < list.size(); i++) {
            String[] parts = array[i].split(";");
            int id = Integer.parseInt(parts[0]);
            int owner = Integer.parseInt(parts[1]);
            String title = parts[2];
            String details = parts[3];

            aList.add(new Advertisement(id, title, details));
        }
        return aList;
    }

    public static void saveUsers(List<User> aList){
        User[] array = new User[aList.size()];
        array = aList.toArray(array);
        String writeString = "";

        for (int i=0; i < aList.size();i++){
            if (array[i].getUserRole() == 1){
                writeString += CreateStringEmployee((Employee) array[i]);
            }else if(array[i].getUserRole() == 2){
                writeString += CreateStringEmployer((Employer) array[i]);
            }else{
                writeString += "0;3;Admin;Admin;" + "\n";
            }
        }

        writeToFile(writeString,"Users");
    }

    public static List<User> getUsers() {
        List<String> list = readFile("Users");
        List<User> aList = new LinkedList<>();
        String[] array = new String[list.size()];
        array = list.toArray(array);

        for (int i = 0; i < list.size(); i++) {
            String[] parts = array[i].split(";");
            int id = Integer.parseInt(parts[0]);
            int userRole = Integer.parseInt(parts[1]);
            String username = parts[2];
            String password = parts[3];

            switch (userRole){
                case 1:
                    String name = parts[4];
                    int age = Integer.parseInt(parts[5]);
                    int pnum = Integer.parseInt(parts[6]);

                    aList.add(new Employee(id,userRole,username, password, name, age, pnum));
                    break;
                case 2:
                    String cName = parts[3];
                    String email = parts[4];
                    String location = parts[5];

                    aList.add(new Employer(id,userRole,username, password, cName, email, location));
                    break;
                case 3:
                    aList.add(new Admin(userRole, username, password));
            }
        }
        return aList;
    }

    private static String CreateStringEmployee(Employee e) {
        String writeString = e.getID() + ";";
        writeString += e.getUserRole() + ";";
        writeString += e.getUsername() + ";";
        writeString += e.getPassword() + ";";
        writeString += e.getName() + ";";
        writeString += e.getAge() + ";";
        writeString += e.getPhoneNumber() + ";";
        writeString += "\n";

        return writeString;
    }

    private static String CreateStringEmployer(Employer e) {
        String writeString = e.getID() + ";";
        writeString += e.getUserRole() + ";";
        writeString += e.getUsername() + ";";
        writeString += e.getPassword() + ";";
        writeString += e.getCompanyName() + ";";
        writeString += e.getEmail() + ";";
        writeString += e.getLocation() + ";";
        writeString += "\n";

        return writeString;
    }

    private static List<String> readFile(String filename) {
        List<String> stringRows = new LinkedList<>();
        try (Scanner fileToRead = new Scanner(new File(filename))) {
            //point the scanner method to a file
            //check if there is a next line and it is not null and then read it in
            for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
                stringRows.add(line);//print each line as its read
                stringBufferOfData.append(line).append("\r\n");//this small line here is to appened all text read in from the file to a string buffer which will be used to edit the contents of the file
            }
            fileToRead.close();//this is used to release the scanner from file
            return stringRows;
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + filename + " could not be found! " + ex.getMessage());
        }
        return stringRows;
    }

    private static void writeToFile(String text,String filename) {
        try {
            BufferedWriter bufwriter = new BufferedWriter(new FileWriter(filename));
            bufwriter.write(text);//writes the edited string buffer to the new file
            bufwriter.close();//closes the file
        } catch (Exception e) {//if an exception occurs
            System.out.println("Error occured while attempting to write to file: " + e.getMessage());
        }
    }
}