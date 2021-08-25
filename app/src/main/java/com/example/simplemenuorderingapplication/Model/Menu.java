package com.example.simplemenuorderingapplication.Model;

public class Menu {
    private int id;
    Categories categories;

    public Menu(int id, Categories categories) {
        this.id = id;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public Categories getCategories() {
        return categories;
    }
}
