package com.packaged;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Database {
	private static Connect con = Connect.getConnection();
	
	//getAll
	public static ArrayList<Food> getAllFoods(){
		//Quesadilla
		String query = "SELECT * FROM quesadilla";
		ArrayList<Food> foods = new ArrayList<>();
		ResultSet rs = con.executeQuery(query);
		try {
			while(rs.next()) {
				Quesadilla q = (Quesadilla)FoodFactory.generateFood("Quesadilla");
				q.setFoodId(rs.getInt("FoodId"));
				q.setFoodName(rs.getString("FoodName"));
				q.setFoodType(rs.getString("FoodType"));
				q.setFoodPrice(rs.getInt("FoodPrice"));
				q.setDippingSauce(rs.getString("DippingSauce"));
				foods.add(q);
				
//				int foodId = rs.getInt("FoodId");
//				String foodName = rs.getString("FoodName");
//				String foodType = rs.getString("FoodType");
//				int foodPrice = rs.getInt("FoodPrice");
//				String dippingSauce = rs.getString("DippingSauce");
//				foods.add(new Quesadilla(foodId, foodName, foodType, foodPrice, dippingSauce));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//Taco
		query = "SELECT * FROM taco";
		rs = con.executeQuery(query);
		try {
			while(rs.next()) {
				Taco t = (Taco)FoodFactory.generateFood("Taco");
				t.setFoodId(rs.getInt("FoodId"));
				t.setFoodName(rs.getString("FoodName"));
				t.setFoodType(rs.getString("FoodType"));
				t.setFoodPrice(rs.getInt("FoodPrice"));
				t.setShellType(rs.getString("ShellType"));
				foods.add(t);
				
//				int foodId = rs.getInt("FoodId");
//				String foodName = rs.getString("FoodName");
//				String foodType = rs.getString("FoodType");
//				int foodPrice = rs.getInt("FoodPrice");
//				String shellType = rs.getString("ShellType");
//				foods.add(new Taco(foodId, foodName, foodType, foodPrice, shellType));
			}
			return foods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//	public static ArrayList<Quesadilla> getAllQuesadilla(){
//		String query = "SELECT * FROM quesadilla";
//		ArrayList<Quesadilla> quesadillas = new ArrayList<>();
//		ResultSet rs = con.executeQuery(query);
//		try {
//			while(rs.next()) {
//				int foodId = rs.getInt("FoodId");
//				String foodName = rs.getString("FoodName");
//				String foodType = rs.getString("FoodType");
//				int foodPrice = rs.getInt("FoodPrice");
//				String dippingSauce = rs.getString("DippingSauce");
//				quesadillas.add(new Quesadilla(foodId, foodName, foodType, foodPrice, dippingSauce));
//			}
//			return quesadillas;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Taco> getAllTaco(){
//		String query = "SELECT * FROM taco";
//		ArrayList<Taco> tacos = new ArrayList<>();
//		ResultSet rs = con.executeQuery(query);
//		try {
//			while(rs.next()) {
//				int foodId = rs.getInt("FoodId");
//				String foodName = rs.getString("FoodName");
//				String foodType = rs.getString("FoodType");
//				int foodPrice = rs.getInt("FoodPrice");
//				String shellType = rs.getString("ShellType");
//				tacos.add(new Taco(foodId, foodName, foodType, foodPrice, shellType));
//			}
//			return tacos;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	// Transaction
	public static void addNewTransaction(Transaction transaction) {
		String query = "INSERT INTO transaction(TransactionId, FoodId, Qty) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, transaction.getTransactionId());
			ps.setInt(2, transaction.getFoodId());
			ps.setInt(3, transaction.getQuantity());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<Transaction> getAllTransaction(){
		String query = "SELECT * FROM transaction";
		ArrayList<Transaction> transactions = new ArrayList<>();
		ResultSet rs = con.executeQuery(query);
		try {
			while(rs.next()) {
				String transactionId = rs.getString("TransactionId");
				int foodId = rs.getInt("FoodId");
				int quantity = rs.getInt("Qty");
				transactions.add(new Transaction(transactionId, foodId, quantity));
			}
			return transactions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean getTransactionById(String transactionId) {
		String query = "SELECT * FROM transaction WHERE TransactionId=?";
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setString(1, transactionId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public static void deleteTransactionById(String transactionId) {
		String query = "DELETE FROM transaction WHERE TransactionId=?";
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setString(1, transactionId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
