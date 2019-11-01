package com.company;

import java.util.ArrayList;

public class Parent extends Person { //extends Person

    private static int idcount = 2000;

    private int identificationnumber;

    private int pupilIdentificationNumber;

    private String emailadress;

    private String phoneNumber;

    //TODO allow multiple children to share the same parent object
    //private ArrayList<PupilArray> children = new ArrayList<PupilArray>();

    Parent(String name, String surname, int pupilIdentificationNumber){
        super(name,surname);
        this.pupilIdentificationNumber = pupilIdentificationNumber;
        addIDCount();
        this.identificationnumber = idcount;
    }

    Parent(String name, String surname, int identificationnumber, int pupilIdentificationNumber, String emailadress, String phoneNumber){
        super(name,surname);
        this.identificationnumber = identificationnumber;
        this.pupilIdentificationNumber = pupilIdentificationNumber;
        this.emailadress = emailadress;
        this.phoneNumber = phoneNumber;
    }

    public static void addIDCount() {
        ++idcount;
    }

    public static int getIdcount(){
        return idcount;
    }

    public static void saveParentsToFile(ArrayList<Parent> parents, String destination) {

        FileIO file = new FileIO();

        file.openStreamToFile(destination);

        file.addRecords(Integer.toString(idcount -2000));
        for (Parent parent: parents) {
            String temp = "";
            temp += parent.getName() + "," + parent.getSurname() + "," + parent.getIdentificationnumber() + "," + parent.getPupilIdentificationNumber() + "," + parent.getEmailadress() + "," + parent.getPhoneNumber();
            file.addRecords(temp);
        }
        file.closeFile();

    }


    public static ArrayList<Parent> loadParentList(String filename){

        ArrayList<Parent> parents = new ArrayList<Parent>();

        //System.out.println("executing loadParentList");

        String temp = "";

        FileIO file = new FileIO();
        file.openStreamFromFile(filename);

        if (file.hasNextLine()) {
            idcount += Integer.parseInt( file.readLine());
            //tempstring = file.readLine();
        }


        while (file.hasNextLine()){

            String line = file.readLine();

            //System.out.println(line);

            String[] lineArray = line.split(",");

            Parent parent = new Parent(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]), lineArray[4], lineArray[5]);

            //parent.display();

            parents.add(parent);
        }

        return parents;
    }

    public int getIdentificationnumber() {
        return identificationnumber;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void display(){
        //helper method to use during development);

        System.out.println(nameToString());
        System.out.println("Child ID: " + getPupilIdentificationNumber() + " ParentID: "+ getIdentificationnumber());
        System.out.println("Adress: " + getEmailadress() + " Phone: " + getPhoneNumber());
    }


    public int getPupilIdentificationNumber() {
        return pupilIdentificationNumber;
    }
}
