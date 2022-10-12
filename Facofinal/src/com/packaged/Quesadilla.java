package com.packaged;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Quesadilla extends Food{
	private String dippingSauce;
	public Quesadilla() {
		
	}
	public Quesadilla(int foodId, String foodName, String foodType, int foodPrice, String dippingSauce) {
		super(foodId, foodName, foodType, foodPrice);
		this.dippingSauce = dippingSauce;
	}
	
	
	public String getDippingSauce() {
		return dippingSauce;
	}
	public void setDippingSauce(String dippingSauce) {
		this.dippingSauce = dippingSauce;
	}
	public int getPrice(int Quantity) {
		return (foodPrice * Quantity) + 5000;
	}

}
