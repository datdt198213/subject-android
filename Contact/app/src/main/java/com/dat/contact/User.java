package com.dat.contact;

public class User {

    private String name;
    private char firstChar;

    public User(String name, char firstChar) {
        this.name = name;
        this.firstChar = firstChar;
    }

    public char getFirstChar() {
        return firstChar;
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
