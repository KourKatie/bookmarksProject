package com.test.util;

/**
 * Created by Katie on 9/26/2017.
 */
public class bottomAdded {

    private String Name;
    private String URL;
    private String Category;

    public bottomAdded(String name, String URL, String category) {
        Name = name;
        this.URL = URL;
        Category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
