package com.packaged;


import java.util.ArrayList;

public abstract class Food {
    protected int foodID;
    protected String foodName;
    protected String foodType;
    protected int price;
    protected Connect con = Connect.getConnection();
    public Food(){

    }

    public Food(int foodID, String foodName, String foodType, int price) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodType = foodType;
        this.price = price;
    }
    public abstract ArrayList<?> getAll();


    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
