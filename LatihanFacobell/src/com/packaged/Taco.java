package com.packaged;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Taco extends Food{
    private String shellType;
    public Taco(){

    }

    public Taco(int foodID, String foodName, String foodType, int price, String shellType) {
        super(foodID, foodName, foodType, price);
        this.shellType = shellType;
    }

    public ArrayList<Taco> getAll(){
        String query = "SELECT * FROM taco";
        ArrayList<Taco> tacos = new ArrayList<>();
        ResultSet rs = con.executeQuery(query);

        try {

            while(rs.next()){
                int foodID = rs.getInt("FoodId");
                String foodName = rs.getString("FoodName");
                String foodType = rs.getString("FoodType");
                int price = rs.getInt("FoodPrice");
                String shellType = rs.getString("ShellType");
                tacos.add(new Taco(foodID, foodName, foodType,price,shellType));
            }
            return tacos;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getShellType() {
        return shellType;
    }

    public void setShellType(String shellType) {
        this.shellType = shellType;
    }
}
