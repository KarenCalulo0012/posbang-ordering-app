package com.example.simplemenuorderingapplication.Model;

public class Food {
    private Integer id;
    private String foodName;
    private int foodPrice;
    private int foodTax;
    private int foodPic;
//    Categories categories;



    public Food(Integer id, String foodName, int foodPrice, int foodTax, int foodPic) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodTax = foodTax;
        this.foodPic = foodPic;
//        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public int getFoodPic() {
        return foodPic;
    }

//    public Integer getCategories() {
//        return categories;
//    }

    public int getFoodTax() {
        return foodTax;
    }
}
