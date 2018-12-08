package com.advertisements;

public class Advertisement implements Advertisements{
    private int id;
    private int owner;
    private String title;
    private String details;
    private boolean highLighted;


    public Advertisement(int id, int owner, String title, String details){
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.details = details;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
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

    public boolean isHighLighted() {
        return highLighted;
    }

    public void setHighLighted(boolean highLighted) {
        this.highLighted = highLighted;
    }
}
