package com.example.isharaj.contactportal.entities;

public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName;
    private String mobileNumber;

    public Person(String firstName, String lastName, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public int compareTo( Person p) {
        return firstName.compareTo(p.firstName);
    }
}
