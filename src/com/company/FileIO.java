package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 */

public class FileIO {

    private Formatter formatter;
    private Scanner scanner;

    public FileIO(){

    }

    /**
     * Opens a stream to a file so that text can be
     * written to it
     *
     * @param destination file that the text is written to
     *
     */

    public void openStreamToFile(String destination){

        try {
            formatter = new Formatter(destination);
        }
        catch (Exception e) {
            System.out.println("You got an error");
        }
    }

    /**
     * writes input string to an already selected file
     * @param string1 that which is to be written to file
     */

    public void addRecords(String string1){
        formatter.format("%s\n", string1);

    }

    /**
     * closes the previously selected file
     */

    public void closeFile(){
        formatter.close();
    }

    /**
     * Opens a stream from a file so that it's content can be read
     * @param fileName file to be opened
     */

    public void openStreamFromFile(String fileName){
        try {
            scanner = new Scanner(new File(fileName));
        }
        catch (Exception e){
            System.out.println("Error, couldn't find file!");
        }

    }

    /**
     * checks if there is a next line in previously selected file
     * @return returns boolean corresponding to if there is a next line in file
     */

    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

    /**
     *
     * @return returns the next line in a previously selected file
     */

     public String readLine(){

        return scanner.nextLine();

        }

    public static void writeQueueObjects(List<QueueDate> myArrayList) {

        ObjectOutputStream objectOutputStream = null;

        FileOutputStream fileOutputStream = null;

        try {

            fileOutputStream = new FileOutputStream("queuedata.ser", false);

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(myArrayList);

            objectOutputStream.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }



    public static List<QueueDate> readQueueObjects(String fileName){

        ObjectInputStream objectinputstream;

        List<QueueDate> queuedates = null;

        try {

            FileInputStream streamIn = new FileInputStream(fileName);

            objectinputstream = new ObjectInputStream(streamIn);

            queuedates = (List<QueueDate>) objectinputstream.readObject();

            objectinputstream .close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return queuedates;

    }

}

