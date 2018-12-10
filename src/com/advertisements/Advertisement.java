package com.advertisements;

import com.company.Main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import com.advertisements.FileManagger;

public class Advertisement {
    private int id;
    private String title;
    private String details;

    public int addedByUserID;


    public List<Advertisement> adList = new LinkedList<>();

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ",Belongs to user: " + addedByUserID + '\'' +
                '}';
    }

    public  Advertisement(){}

    public Advertisement(int id, String title, String details, int uID) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.addedByUserID = uID;
    }


    public int getAddedByUserID() {
        return addedByUserID;
    }

    public void setAddedByUserID(int addedByUserID) {
        this.addedByUserID = addedByUserID;
    }

    public void addHighLight() {
        this.title = "[HIGHLIGHTED]  " + this.title.toUpperCase();
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public void listAds(){
        for (int i=0; i< adList.size(); i++){
            System.out.println(adList.get(i));
        }
    }

    public int listFuckinAds(int userID){
        setAddedByUserID(userID);
        int existed = 0;
        for (int i=0; i< adList.size(); i++){
            if(adList.get(i).getAddedByUserID() == userID) {
                System.out.println(adList.get(i));
                existed = 1;
            }
        }
        if(existed == 1){
            return 1;
        } else {
            return 0;
        }
    }

    public void newAd(int currentUserID) {
        Scanner input = new Scanner(System.in);
        int currId = adList.size();
        int ownedBy = currentUserID;
        System.out.println("Title: ");
        String currTitle = input.nextLine();
        System.out.println("Details: ");
        String currDetails = input.nextLine();
        adList.add(currId, new Advertisement(currId, currTitle, currDetails,ownedBy));
        highlightQuestion(currId);
        FileManagger.saveAdvertisements(adList);
    }

    public void modifyAd(int currentUserID){
        Scanner input = new Scanner(System.in);

        System.out.println("List of advertisements:");
        int advExist = listFuckinAds(currentUserID);

        if(advExist == 1) {
            System.out.println("Which advertisement do you like to modify?");
            int idx = input.nextInt();
            System.out.println(adList.get(idx));
            adList.remove(idx);

            newAd(currentUserID);
        } else {
            System.out.println("You dont have any advertisment!");
        }
    }

    public void deleteAd(int userID) {
        Scanner input = new Scanner(System.in);

        System.out.println("List of advertisements:");
        int advExist = listFuckinAds(userID);
        if(advExist == 1) {
            System.out.println("Which advertisement do you like to delete?");
            int idx = input.nextInt();
            adList.remove(idx);
        } else {
            System.out.println("You dont have any advertisement!");
        }
    }

    public void highlightQuestion(int idx){
        Scanner input = new Scanner(System.in);

        System.out.println("Do you like to highlight your advertisement? (yes/no)");
        String decision = input.nextLine();
        boolean likeTo = true;
        while (likeTo) {
            if ("yes".equals(decision)) {
                adList.get(idx).addHighLight();
                likeTo = false;
            } else if ("no".equals(decision)) {
                likeTo = false;
            } else {
                System.out.println("Something went wrong! Try again.");
            }
        }
    }
}
