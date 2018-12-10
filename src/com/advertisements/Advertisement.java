package com.advertisements;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Advertisement {
    private int id;
    private String title;
    private String details;
    private int owner;

    public List<Advertisement> adList = new LinkedList<>();

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    public  Advertisement(){}

    public Advertisement(int id, String title, String details, int owner) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.owner = owner;
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

    public void newAd() {
        Scanner input = new Scanner(System.in);
        int currId = adList.size();
        System.out.println("Title: ");
        String currTitle = input.nextLine();
        System.out.println("Details: ");
        String currDetails = input.nextLine();
        adList.add(currId, new Advertisement(currId, currTitle, currDetails,owner));
        highlightQuestion(currId);
        FileManagger.saveAdvertisements(adList);
    }

    public void modifyAd(){
        Scanner input = new Scanner(System.in);

        System.out.println("List of advertisements:");
        listAds();

        System.out.println("Which advertisement do you like to modify?");
        int idx = input.nextInt();
        System.out.println(adList.get(idx));
        adList.remove(idx);

        newAd();
    }

    public void deleteAd() {
        Scanner input = new Scanner(System.in);

        System.out.println("List of advertisements:");
        listAds();

        System.out.println("Which advertisement do you like to delete?");
        int idx = input.nextInt();
        adList.remove(idx);
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
