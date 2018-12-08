package com.advertisements;
import  com.advertisements.Advertisement;

public interface Advertisements {

    public void addHightLight(int id);
    public void removeHightLight(int id);
    public void delete(Advertisement a);
    public void list();
    public void add(Advertisement a);
    public void modify(Advertisement a);
}
