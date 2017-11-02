package com.test.util;

/**
 * Created by Katie on 9/26/2017.
 */
public class Information {

    private String Name;
    private String Description;
    private String URL;
    private String Date;
    private String Category;

    public Information(String name, String description, String URL, String date, String category) {
        Name = name;
        Description = description;
        this.URL = URL;
        Date = date;
        Category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }



}
