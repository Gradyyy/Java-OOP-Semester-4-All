package com.packaged;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Quesadilla extends Food {
    private String dippingSauce;
    public Quesadilla(){

    }

    public Quesadilla(int foodID, String foodName, String foodType, int price, String dippingSauce) {
        super(foodID, foodName, foodType, price);
        this.dippingSauce = dippingSauce;
    }

    public ArrayList<Quesadilla> getAll(){
        String query = "SELECT * FROM quesadilla";
        ArrayList<Quesadilla> quesadillas = new ArrayList<>();
        ResultSet rs = con.executeQuery(query);

        try {

            while(rs.next()){
                int foodID = rs.getInt("FoodId");
                String foodName = rs.getString("FoodName");
                String foodType = rs.getString("FoodType");
                int price = rs.getInt("FoodPrice");
                String dippingSauce = rs.getString("DippingSauce");
                quesadillas.add(new Quesadilla(foodID, foodName, foodType,price,dippingSauce));
            }
            return quesadillas;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getDippingSauce() {
        return dippingSauce;
    }

    public void setDippingSauce(String dippingSauce) {
        this.dippingSauce = dippingSauce;
    }
}
