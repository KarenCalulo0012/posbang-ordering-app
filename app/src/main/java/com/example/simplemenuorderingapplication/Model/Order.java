package com.example.simplemenuorderingapplication.Model;

public class Order {
    private int id;
    private int totalAmount;
    Menu menu;

    public Order(int id, int totalAmount, Menu menu) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public Menu getMenu() {
        return menu;
    }
}
