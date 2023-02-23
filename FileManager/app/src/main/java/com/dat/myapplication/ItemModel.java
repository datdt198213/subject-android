package com.dat.myapplication;

import java.io.File;

public class ItemModel {
    private String name;
    private String icon;
    private File path;


    public ItemModel(String name, String icon, File path) {
        this.name = name;
        this.icon = icon;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }
}
