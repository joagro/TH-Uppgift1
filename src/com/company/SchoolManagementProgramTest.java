package com.company;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SchoolManagementProgramTest {

    private SchoolManagementProgram schoolManagementProgram = new SchoolManagementProgram();

    @Test
    public void run() {


    }

    @Test
    public void addPupilMenu() {
        int pupillength = schoolManagementProgram.getPupilList().size();

        ArrayList<Pupil> pupils = schoolManagementProgram.getPupilList();

        Parent firstparent = new Parent("Felix", "Svanberg", 1001);
        Parent secondparent = new Parent("Ylva", "Svanberg", 1001);

        Pupil pupil = new Pupil("Anton", "Svanberg", firstparent, secondparent);

        pupils.add(pupil);


        assertEquals(1,pupils.size() - pupillength );


    }
}