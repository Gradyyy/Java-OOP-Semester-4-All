package com.packaged;

import java.util.ArrayList;


public abstract class Food{
	protected int foodId;
	protected String foodName;
	protected String foodType;
	protected int foodPrice;
	protected Connect con = Connect.getConnection();
	public Food() {
		
	}
	public Food(int foodId, String foodName, String foodType, int foodPrice) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodPrice = foodPrice;
	}
	
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
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
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	abstract int getPrice(int Quantity);
	
	
}
