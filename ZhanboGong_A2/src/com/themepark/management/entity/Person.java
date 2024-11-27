package com.themepark.management.entity;

public class Person {
    protected int ID;
    protected String firstName;
    protected String lastName;
    protected String mobileNumber;

    public Person(int ID, String firstName, String lastName, String mobileNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }
}
