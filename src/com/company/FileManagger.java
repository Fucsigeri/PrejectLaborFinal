package com.company;
/*
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManagger {
    private void writeToFile(String text){
        try {
            BufferedWriter bufwriter = new BufferedWriter(new FileWriter("Advertisements"));
            bufwriter.write(text.toString());
            bufwriter.close();
        } catch (Exception e) {
            System.out.println("Error occured while attempting to write to file: " + e.getMessage());
        }
    }

    private static boolean readFile() {
        String filename = "Advertisements";
        Scanner fileToRead = null;
        try {
            fileToRead = new Scanner(new File(filename));
            for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
                System.out.println(line);//print each line as its read
            }
            fileToRead.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("The file " + filename + " could not be found! " + ex.getMessage());
            return false;
        } finally {
            fileToRead.close();
            return true;
        }
    }
       private static void replacement() {
        StringBuffer stringBufferOfData = new StringBuffer();
        String filename = null;
        Scanner sc = new Scanner(System.in);//initiliaze scanner to get user input
        public static void main(String[] args) {
            boolean fileRead = readFile();//call the method to read the file with the files name
            if (fileRead) {//if the read file was successfull
                replacement();//call method to get text to replace, replacement text and output replaced String buffer
                writeToFile();
            }
            System.exit(0);//exit once app is done
        }


        String lineToEdit = sc.nextLine();//read the line to edit
        System.out.println("Please enter the the replacement text: ");//prompt for a line in file to replace
        String replacementText = sc.nextLine();//read the line to replace
        //System.out.println(sb);//used for debugging to check that my stringbuffer has correct contents and spacing
        String stringBufferOfData = "asdsad";
        int startIndex = stringBufferOfData.indexOf(lineToEdit);//now we get the starting point of the text we want to edit
        int endIndex = startIndex + lineToEdit.length();//now we add the staring index of the text with text length to get the end index
        stringBufferOfData.replace(startIndex, endIndex, replacementText);//this is where the actual replacement of the text happens
        System.out.println("Here is the new edited text:\n" + stringBufferOfData); //used to debug and check the string was replaced
    }
}
*/