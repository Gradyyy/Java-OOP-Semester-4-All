package com.packaged;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	Scanner scan = new Scanner(System.in);
	void clearScreen() {
		for(int i=0;i<50;i++) {
			System.out.println("");
		}
	}
	Main(){
		int choice = -1;
		do {
			clearScreen();
			System.out.println("FAcobell");
			System.out.println("========================");
			System.out.println("1. View All Transactions");
			System.out.println("2. Buy Food");
			System.out.println("3. Delete Transaction");
			System.out.println("4. Exit");
			System.out.print(">> ");
			choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
				case 1:	
					menu_viewTransaction();
					break;
				case 2:
					menu_buyFood();
					break;
				case 3:
					menu_deleteTransaction();
					break;
			}
		}while(choice != 4);
	}
	private void menu_deleteTransaction() {
		// TODO Auto-generated method stub
		clearScreen();
		ArrayList<Transaction> transactions = Database.getAllTransaction();
		if(transactions.isEmpty()) {
			System.out.println("No Transaction");
			return;
		}	
		showAllTransaction();
		String targetTransactionId;
//		do {
//			System.out.print("Choose transaction to delete [TRXXX]: ");
//			targetTransactionId = scan.nextLine();
//		}while((new Transaction(targetTransactionId)).getById() == false);
		do {
			System.out.print("Choose transaction to delete [TRXXX]: ");
			targetTransactionId = scan.nextLine();
		}while(Database.getTransactionById(targetTransactionId) == false);
		
//		new Transaction(targetTransactionId).deleteById(); // awal
		Database.deleteTransactionById(targetTransactionId); // baru
		System.out.println("Deleted!!!!!");
		System.out.println("Press enter to continue..");
		scan.nextLine();
	}
	private void menu_viewTransaction() {
		// TODO Auto-generated method stub
		clearScreen();
		ArrayList<Transaction> transactions = Database.getAllTransaction();
		if(transactions.isEmpty()) {
			System.out.println("No Transaction");
			return;
		}
		
		showAllTransaction();
		System.out.println("Press enter to continue..");
		scan.nextLine();
	}
	private void showAllTransaction() {
		// TODO Auto-generated method stub
		ArrayList<Transaction> transactions = Database.getAllTransaction();
		int index = 1;
		for(Transaction t : transactions) {
			Food food = getFoodDataById(t.getFoodId());
			int totalAfterTax = 0;
			if(food.getFoodType().equals("Taco")) {
				totalAfterTax = (food.getFoodPrice() * t.getQuantity()) + 5000;
			}
			else if(food.getFoodType().equals("Quesadilla")) {
				totalAfterTax = (food.getFoodPrice() * t.getQuantity()) + 3000;
			}
			System.out.printf("| %-3d | %-10s | %-20s | %-3d | IDR %-20d | IDR %-20d |\n", index++, t.getTransactionId(), food.getFoodName(), t.getQuantity(), food.getFoodPrice(), totalAfterTax);
		}
	}
	private void menu_buyFood() {
		// TODO Auto-generated method stub
		clearScreen();
		showFoods();
		
		int foodId;
		int quantity;
		do {
			System.out.print("Choose food to buy [1-10]: ");
			foodId = scan.nextInt();
			scan.nextLine();
		} while (foodId < 1 || foodId > 10);
		do {
			System.out.print("Input quantity to buy [more than 0]: ");
			quantity = scan.nextInt();
			scan.nextLine();
		} while (quantity <= 0);
		// GenerateId;
		String transactionId = generateTransactionId();
		Food orderedFood = getFoodDataById(foodId);
		
		String foodName = orderedFood.getFoodName();
		int foodPrice = orderedFood.getFoodPrice();
		int totalAfterTax = 0;
		if(orderedFood.getFoodType().equals("Taco")) {
			totalAfterTax = (foodPrice * quantity) + 5000;
		}
		else if(orderedFood.getFoodType().equals("Quesadilla")) {
			totalAfterTax = (foodPrice * quantity) + 3000;
		}
		
		System.out.println("TransactionDetail");
		System.out.println("=========================");
		System.out.printf("%-25s: %s\n", "Transaction ID", transactionId);
		System.out.printf("%-25s: %s\n", "Food Name", foodName);
		System.out.printf("%-25s: %d\n", "Qty", quantity);
		System.out.printf("%-25s: IDR %d\n", "Food Price", foodPrice);
		System.out.printf("%-25s: IDR %d\n", "Total after Tax", totalAfterTax);
		
		// Insert to Database
		// TransactionId, FoodId, Quantity
		Database.addNewTransaction(new Transaction(transactionId, foodId, quantity));
		System.out.println("");
		System.out.println("Successfully bought food!");
		System.out.println("");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		return;
	}
	private String generateTransactionId() {
		String id = "TR";
		for(int i=0;i<3;i++) {
			id += Integer.toString((int)(Math.random()*10));
		}
		return id;
	}
	private void showFoods() {
		// TODO Auto-generated method stub
		ArrayList<Food> foods = Database.getAllFoods();
		for(Food t : foods) {
			if(t instanceof Taco) {
				System.out.printf("| %-3d | %-20s | %-15s | %-15s | %-15s | %-15s |\n", t.getFoodId(), t.getFoodName(), t.getFoodType(), t.getFoodPrice(), ((Taco)t).getShellType(),"-");				
			}
			else {
				System.out.printf("| %-3d | %-20s | %-15s | %-15s | %-15s | %-15s |\n", t.getFoodId(), t.getFoodName(), t.getFoodType(), t.getFoodPrice(), "-", ((Quesadilla)t).getDippingSauce());
			}
		}
		return;
	}
	private Food getFoodDataById(int id) {
		// ID = 6
		// -> Taco
		// ID = 4
		// -> Quesadilla
		
//		if(id <= 5) {
//			Quesadilla list_quesadilla = new Quesadilla();
//			ArrayList<Quesadilla> quesadillas = list_quesadilla.getAll();
//			return quesadillas.get(id-1);
//		}
//		else {
//			Taco list_taco = new Taco();
//			ArrayList<Taco> tacos = list_taco.getAll();
//			return tacos.get(id-6);
//		}
		ArrayList<Food> foods = Database.getAllFoods();
		return foods.get(id-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
