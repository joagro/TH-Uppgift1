package com.company;
import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    private String surname;

    private int identificationNumber;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String nameToString() {
        return getName() + " " + getSurname();
    }

    //private String phoneNumber;

}
