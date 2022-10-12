package com.packaged;

public class FoodFactory {
	public static Food generateFood(String foodType) {
		if(foodType.equals("Quesadilla")) {
			return new Quesadilla();
		}
		else if(foodType.equals("Taco")) {
			return new Taco();
		}
		return null;
	}
}
