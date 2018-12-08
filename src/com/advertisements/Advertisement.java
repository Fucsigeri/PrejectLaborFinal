package com.advertisements;

public class Advertisement implements Advertisements{
    private int owner;
    private String title;
    private String details;
    private boolean hightLighted;

    public Advertisement(int owner, String title, String details){
        this.owner = owner;
        this.title = title;
        this.details = details;
    }

    @Override
    public void addHightLight(int id) {

    }

    public void removeHightLight(int id) {

    }

    @Override
    public void delete(Advertisement a) {

    }

    @Override
    public void list() {

    }

    @Override
    public void add(Advertisement a) {

    }

    @Override
    public void modify(Advertisement a) {

    }

    public void setTitle(String title){

    }

    public String getTitle(){

    }

    public void setDetails(String title){

    }

    public String getDetails(){

    }

    public int getIdByName(){

    }

}
