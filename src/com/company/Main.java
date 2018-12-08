package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import com.advertisements.Advertisement;
import com.advertisements.FileManagger;

public class Main {

    public static void main(String[] args) {

        //test
        List<Advertisement> advertisements = new LinkedList<Advertisement>();
        advertisements.add(new Advertisement(1,3,"title1","details1"));
        advertisements.add(new Advertisement(2,2,"title2","details2"));
        advertisements.add(new Advertisement(3,1,"title3","details3"));
        FileManagger.saveAdvertisements(advertisements);
        FileManagger.getAdvertisements();
    }
}
