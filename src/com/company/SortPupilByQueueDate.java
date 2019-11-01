package com.company;

import java.util.Comparator;

public class SortPupilByQueueDate implements Comparator<Pupil> {

    // used for sorting in descending order of
    // Queuedate startdate
    public int compare(Pupil a, Pupil b)
    {
        return a.getQueuedate().compareTo(b.getQueuedate());
    }
}

