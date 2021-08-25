package com.example.simplemenuorderingapplication.Model;

import java.util.ArrayList;

public class Categories {
    private int id;
    private String categoryName;
    int image;

    public Categories(int id, String categoryName, int image) {
        this.id = id;
        this.categoryName = categoryName;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", image=" + image +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getImage() {
        return image;
    }
}
