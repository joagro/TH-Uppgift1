package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pupil extends Person {

    private static int idcount = 1000;

    private Parent[] parents = new Parent[2];

    private int identificationNumber;

    //private int queuedays;

    private QueueDate queuedate;

    Pupil(String name, String surname, int identificationNumber) {
        super(name,surname);
        this.identificationNumber = identificationNumber;

    }

    Pupil(String name, String surname,Parent firstparent, Parent secondparent) {
        super(name, surname);
        addIDcount();
        this.identificationNumber = idcount;
        parents[0] = firstparent;
        parents[1] = secondparent;
    }

    public static void addIDcount() {
        ++idcount;
    }

    public static void savePupilsToFile(ArrayList<Pupil> listtosave, String filename) {
        FileIO file = new FileIO();

        file.openStreamToFile(filename);

        file.addRecords(Integer.toString(idcount -1000));

        for(Pupil pupil: listtosave) {
            String tempstring = "";
            tempstring += pupil.getName() + "," + pupil.getSurname() + "," + pupil.getIdentificationNumber();
            file.addRecords(tempstring);
        }
        file.closeFile();
    }

    public static ArrayList<Pupil> loadPupilList(String filename, ArrayList<Parent> listofparents, List<QueueDate> queueDateList) {

        ArrayList<Pupil> pupils = new ArrayList<Pupil>();

        FileIO file = new FileIO();
        file.openStreamFromFile(filename);

        String tempstring = "";


        tempstring = file.readLine();
        idcount += Integer.parseInt( tempstring);

        while (file.hasNextLine()){

            String line = file.readLine();

            String[] lineArray = line.split(",");

            Pupil pupil = new Pupil(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]));

            for (QueueDate queueDate: queueDateList) {
                if (queueDate.getPupilID() == pupil.getIdentificationNumber()){
                    pupil.setQueuedate(queueDate);
                }

            }

            int parentIndex = 0;

            for (Parent parent: listofparents) {
                if (parent.getPupilIdentificationNumber() == pupil.getIdentificationNumber()){

                    pupil.addParent(parentIndex, parent);
                    parentIndex++;

                }
            }

            pupils.add(pupil);
        }
        return pupils;

    }



    public void addParent(int index, Parent parent) {
        this.parents[index] = parent;
    }

    public Parent[] getParents() {
        return parents;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public String getQueuedays() {
        return queuedate.getDaysSince(new Date());
    }

    public void setQueuedate(QueueDate queuedate) {
        this.queuedate = queuedate;
    }

    public Date getQueuedate(){

        return queuedate.getStartDate();
    }

    public static int getIdcount() {
        return idcount;
    }
}
