package com.dat.email;

public class Email {
    private String name;
    private String content;
    private String time;
    private boolean checkFavorite;
    private char firstChar;

    public Email() {
    }

    public Email(String name, String content, String time, boolean checkFavorite) {
        this.name = name;
        this.content = content;
        this.time = time;
        this.checkFavorite = checkFavorite;
        this.firstChar = name.charAt(0);
    }

    public char getFirstChar() {
        return firstChar;
    }

    public void setFirstChar() {
        this.firstChar = name.charAt(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCheckFavorite() {
        return checkFavorite;
    }

    public void setCheckFavorite(boolean checkFavorite) {
        this.checkFavorite = checkFavorite;
    }
}
