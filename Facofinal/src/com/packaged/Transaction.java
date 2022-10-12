package com.packaged;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Transaction {
	private String transactionId;
	private int foodId;
	private int quantity;
	private Connect con = Connect.getConnection();
	
	public Transaction(String transactionId, int foodId, int quantity) {
		this.transactionId = transactionId;
		this.foodId = foodId;
		this.quantity = quantity;
	}
	public Transaction(String transactionId) {
		this.transactionId = transactionId;
	}
	public Transaction() {
		
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
