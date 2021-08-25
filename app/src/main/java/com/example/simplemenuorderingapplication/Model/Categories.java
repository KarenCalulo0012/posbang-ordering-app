package com.example.simplemenuorderingapplication.Model;

public class Categories {
    private int id;
    private String categoryName;
    int image;

    public Categories(int id, String categoryName, int image) {
        this.id = id;
        this.categoryName = categoryName;
        this.image = image;
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
