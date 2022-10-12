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

    public Transaction(){

    }

    public void addToDatabase(){
        String query = "INSERT INTO Transaction(TransactionId, FoodId, Qty) VALUE(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        try {
            ps.setString(1, transactionId);
            ps.setInt(2, foodId);
            ps.setInt(3,quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transaction> getAll(){
        String query = "SELECT * FROM transaction";
        ArrayList<Transaction> transactions = new ArrayList<>();
        ResultSet rs = con.executeQuery(query);

        try {

            while(rs.next()){
                String transactionId = rs.getString("TransactionId");
                int foodId = rs.getInt("FoodId");
                int quantity = rs.getInt("Qty");
                transactions.add(new Transaction(transactionId,foodId,quantity));
            }
            return transactions;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
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

    public boolean getById(){
        String query = "SELECT * FROM transaction WHERE TransactionId=?";
        PreparedStatement ps =con.prepareStatement(query);
        try {
            ps.setString(1,transactionId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
//    LEARN
    public Transaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public void deleteById(){
        String query = "DELETE FROM transaction WHERE TransactionId=?";
        PreparedStatement ps =con.prepareStatement(query);
        try {
            ps.setString(1,transactionId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
