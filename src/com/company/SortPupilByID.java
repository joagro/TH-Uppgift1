package com.company;

        import java.util.Comparator;

public class SortPupilByID implements Comparator<Pupil> {
    // used for sorting in ascending order of
    // ID number
    public int compare(Pupil a, Pupil b)
    {
        return a.getIdentificationNumber() - b.getIdentificationNumber();
    }
}

