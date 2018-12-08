package com.advertisements;

public class Advertisement implements Advertisements{
    private int owner;
    private String title;
    private String details;
    private boolean highLighted;


    public Advertisement(int owner, String title, String details){
        this.owner = owner;
        this.title = title;
        this.details = details;
    }


    @Override
    public void addHighLight(int d){

    }

    @Override
    public void removeHighLight(int id) {

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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
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

    public boolean isHighLighted() {
        return highLighted;
    }

    public void setHighLighted(boolean highLighted) {
        this.highLighted = highLighted;
    }


}
