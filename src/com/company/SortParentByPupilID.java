package com.company;

import java.util.Comparator;

public class SortParentByPupilID implements Comparator<Parent> {
    // used for sorting in ascending order of
    // ID number
    public int compare(Parent a, Parent b) {
        return a.getPupilIdentificationNumber() - b.getPupilIdentificationNumber();
    }
}