package com.company;

import java.util.*;

public class SchoolManagementProgram {

    private ArrayList<Pupil> pupils; // = new ArrayList<Pupil>();

    private ArrayList<Parent> parents; //= new ArrayList<Parent>();

    private List<QueueDate> queuedates;


    public SchoolManagementProgram() {

        parents = Parent.loadParentList("parents.txt");
        queuedates = FileIO.readQueueObjects("queuedata.ser");
        pupils = Pupil.loadPupilList("pupils.txt", parents, queuedates);

    }

    public ArrayList<Pupil> getPupilList() {
        return pupils;
    }

    private enum MenuItem{
        ADD_CHILD("Add Pupil"),
        REMOVE_PUPIL("Remove Pupil"),
        Display_PUPIL("List all Pupils"),
        SHOW_QUEUE("Show queue"),
        LIST_PARENTS("List all parents"),
        QUIT_PROGRAM("Quit program");

        private String description;

        MenuItem(String description) {
            this.description = description;
        }


        public String getDescription() {
            return description;
        }
    }

    public void addPupil() {

        String name, surname,address, phonenr, pupilname, pupilsurname;

        System.out.println("Pupils count: " + Pupil.getIdcount());
        System.out.println("Parents count: " + Parent.getIdcount());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first name of pupil");
        pupilname = scanner.next();

        System.out.println("Enter  surname of pupil");
        pupilsurname = scanner.next();

        System.out.println("Enter the first parent's first name");
        name = scanner.next();

        System.out.println("Enter the first parent's surname");
        surname = scanner.next();

        System.out.println("Enter the first parent's email address");
        address = scanner.next();

        System.out.println("Enter the first parent's phone number");
        phonenr = scanner.next();

        Parent firstparent = new Parent(name, surname, Parent.getIdcount() +1, Pupil.getIdcount() +1, address, phonenr);
        Parent.addIDCount();

        System.out.println("Enter the second parent's first name");
        name = scanner.next();

        System.out.println("Enter the second parent's surname");
        surname = scanner.next();

        System.out.println("Enter the second parent's email address");
        address = scanner.next();

        System.out.println("Enter the second parent's phone number");
        phonenr = scanner.next();

        Parent secondparent = new Parent(name, surname, Parent.getIdcount() +1, Pupil.getIdcount() +1, address, phonenr);
        Parent.addIDCount();


        QueueDate today = new QueueDate(Pupil.getIdcount() + 1);


        Pupil pupil = new Pupil(pupilname, pupilsurname, firstparent, secondparent);
        pupil.setQueuedate(today);

        System.out.println("Pupils count: " + Pupil.getIdcount());
        System.out.println("Parents count: " + Parent.getIdcount());

        pupils.add(pupil);
        parents.add(firstparent);
        parents.add(secondparent);
        queuedates.add(today);

    }

    private void displayPupil() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter pupil ID number:");
        int id = scanner.nextInt();
        boolean found = false;
        int index;

        for (Pupil pupil: pupils) {
            if(pupil.getIdentificationNumber() == id) {
                System.out.println("Pupil: " + pupil.getName() + " " + pupil.getSurname());
                System.out.println("Pupil ID: " + pupil.getIdentificationNumber());
                System.out.println("Queue days: " + pupil.getQueuedays());
                System.out.println();
                for (Parent parent : pupil.getParents()) {
                    System.out.println(parent.nameToString());
                    System.out.println("Address: " + parent.getEmailadress());
                    System.out.println("Phone: " + parent.getPhoneNumber());
                }
                break;
            }
        }
        /*



         */
    }

    private void displayQueue() {
        for (Pupil pupil: pupils) {
            System.out.println("Pupil: " + pupil.getName() + " " + pupil.getSurname());
            System.out.println("Pupil ID: " + pupil.getIdentificationNumber());
            System.out.println("Queue days: " + pupil.getQueuedays());
            System.out.println();
        }

    }

    private void displayParents() {

        for (Parent parent: parents) {
            System.out.println(parent.nameToString());
        }
    }

    private void removePupile() {

        System.out.println("Removing pupile, enter pupile ID");

        Scanner scanner = new Scanner(System.in);

        int pupilID = scanner.nextInt();

        for (int i =0; i< pupils.size(); i++) {
            if (pupils.get(i).getIdentificationNumber() == pupilID) {
                pupils.remove(i);
                break;

            }
        }
        for (int i = 0; i< queuedates.size(); i++){
            if (queuedates.get(i).getPupilID() == pupilID){
                queuedates.remove(i);
                break;
            }
        }


        for (int j=0; j < 2; j++) {
            for (int i =0; i< parents.size(); i++) {
                if (parents.get(i).getPupilIdentificationNumber() == pupilID) {
                    parents.remove(i);
                    break;
                }
            }
        }

    }

    private void displayMenu() {

        int i =1;

        for (MenuItem menuItem: MenuItem.values()){
            System.out.println(i + ": " + menuItem.getDescription());
            i++;
        }

    }

    private static ArrayList<Parent> createParents() {

        //helper method to use during development);

        ArrayList<Parent> tempparents = new ArrayList<Parent>();

        Parent parent1 = new Parent("Siv","Jensen",2007,1004, "siv.jensen@gmail.com", "0708080811");
        Parent parent2 = new Parent("Otto","Jensen",2008,1004, "otto.jensen@gmail.com", "0735872211");
        Parent parent3 = new Parent("Hanna","Petterson",2003,1002, "hanna.petterson@gmail.com", "0220145687");
        Parent parent4 = new Parent("Rytger","Petterson",2004,1002, "rytger.petterson@gmail.com","0739123456");
        Parent parent5 = new Parent("Anton","Jonsson",2001,1001, "anton.jonsson@gmail.com", "0734291959");
        Parent parent6 = new Parent("Annika","Jonsson",2002,1001, "annika.jonsson@gmail.com", "0777882322");
        Parent parent7 = new Parent("Erik","Hansson",2005,1003, "erik.hansson@gmail.com","0709223981");
        Parent parent8 = new Parent("Victoria","Hansson",2006,1003,"victoria.hansson@gmail.com","0732080912");

        Parent.addIDCount();
        tempparents.add(parent1);
        Parent.addIDCount();
        tempparents.add(parent2);
        Parent.addIDCount();
        tempparents.add(parent3);
        Parent.addIDCount();
        tempparents.add(parent4);
        Parent.addIDCount();
        tempparents.add(parent5);
        Parent.addIDCount();
        tempparents.add(parent6);
        Parent.addIDCount();
        tempparents.add(parent7);
        Parent.addIDCount();
        tempparents.add(parent8);

        /*
        8
        Siv,Jensen,2007,1004
        Otto,Jensen,2008,1004
        Hanna,Petterson,2003,1002
        Rytger,Petterson,2004,1002
        Anton,Jonsson,2001,1001
        Annika,Jonsson,2002,1001
        Erik,Hansson,2005,1003
        Victoria,Hansson,2006,1003

         */
        return tempparents;
    }

    private ArrayList<Pupil> createPupils( ArrayList<Parent> list_of_parents) {

        //helper method to use during development);

        ArrayList<Pupil> temppupils = new ArrayList<Pupil>();

        Pupil pupil_1 = new Pupil("Iben","Jensen",1004);
        Pupil pupil_2 = new Pupil("Agnes","Petterson",1002);
        Pupil pupil_3 = new Pupil("Vincent","Hansson",1003);
        Pupil pupil_4 = new Pupil("Oskar","Jonsson",1001);

        Pupil.addIDcount();
        temppupils.add(pupil_1);
        Pupil.addIDcount();
        temppupils.add(pupil_2);
        Pupil.addIDcount();
        temppupils.add(pupil_3);
        Pupil.addIDcount();
        temppupils.add(pupil_4);

        for ( Pupil pupil: temppupils){
            int i = 0;
            for (Parent parent: list_of_parents) {
                if (parent.getPupilIdentificationNumber() == pupil.getIdentificationNumber()) {
                    pupil.addParent(i, parent);
                    i++;
                }
            }
        }

        return temppupils;
    }

    private ArrayList<QueueDate> createQDates() {

        //helper method to use during development);

        ArrayList<QueueDate> tempqueuedates = new ArrayList<QueueDate>();

        /*
        Iben,Jensen,1004,99
        Agnes,Petterson,1002,95
        Vincent,Hansson,1003,29
        Oskar,Jonsson,1001,7

         */
        //String format "dd MM yyyy"
        QueueDate qdate_1 = new QueueDate("01 02 2019", 1001 );
        QueueDate qdate_2 = new QueueDate("11 04 2019", 1002 );
        QueueDate qdate_3 = new QueueDate("27 07 2019", 1003 );
        QueueDate qdate_4 = new QueueDate("07 09 2019", 1004 );
        tempqueuedates.add(qdate_1);
        tempqueuedates.add(qdate_2);
        tempqueuedates.add(qdate_3);
        tempqueuedates.add(qdate_4);


        return tempqueuedates;
    }

    public void saveData(){
        Parent.saveParentsToFile(parents, "parents2.txt");
        Pupil.savePupilsToFile(pupils, "pupils.txt");
        FileIO.writeQueueObjects(queuedates);
    }

    public void run(){

        int userChoice;

        //TODO look into arraylist and list compitability

        do {
            displayMenu();
            Scanner keyboard = new Scanner(System.in);
            userChoice = keyboard.nextInt() -1;

            switch (MenuItem.values()[userChoice]){

                case ADD_CHILD:
                    addPupil();
                    break;

                case REMOVE_PUPIL:
                    removePupile();
                    break;

                case Display_PUPIL:
                    Collections.sort(pupils, new SortPupilByID());
                    displayPupil();
                    break;

                case LIST_PARENTS:
                    Collections.sort(parents, new SortParentByPupilID());
                    displayParents();
                    break;

                case SHOW_QUEUE:
                    Collections.sort(pupils, new SortPupilByQueueDate());
                    displayQueue();
                    break;

                case QUIT_PROGRAM:
                    break;

                default:
                    System.out.println("Error! wrong input!");
                    break;
            }

        }while (MenuItem.values()[userChoice]!= MenuItem.QUIT_PROGRAM);

        saveData();

    }
}
