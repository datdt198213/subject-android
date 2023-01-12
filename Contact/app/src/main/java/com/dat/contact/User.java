package com.dat.contact;

public class User {

    private String name;
    private char firstChar;
    private String phoneNumber;

    public User(String name, char firstChar) {
        this.name = name;
        this.firstChar = firstChar;
        phoneNumber = "0348247064";
    }

    public char getFirstChar() {
        return firstChar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstChar(char firstChar) {
        this.firstChar = firstChar;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
