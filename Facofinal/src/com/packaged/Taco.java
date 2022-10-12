package com.packaged;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Taco extends Food {
	private String shellType;
	public Taco() {
		
	}
	public Taco(int foodId, String foodName, String foodType, int foodPrice, String shellType) {
		super(foodId, foodName, foodType, foodPrice);
		this.shellType = shellType;
	}
	public String getShellType() {
		return shellType;
	}

	public void setShellType(String shellType) {
		this.shellType = shellType;
	}
	public int getPrice(int Quantity) {
		return (foodPrice * Quantity) + 3000;
	}
	
}
