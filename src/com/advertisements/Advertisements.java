package com.advertisements;
import  com.advertisements.Advertisement;

public interface Advertisements {
    void addHighLight(int d);            // en
    void removeHighLight(int id);        // en
    void delete(Advertisement a);
    void list();                         // en
    void add(Advertisement a);
    void modify(Advertisement a);
}
