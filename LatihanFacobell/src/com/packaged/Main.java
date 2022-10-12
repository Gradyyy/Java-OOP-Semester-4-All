package com.packaged;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    public Main(){
        int choose;

        do{
            System.out.println("FAcobell");
            System.out.println("====================");
            System.out.println("1. View All Transaction");
            System.out.println("2. Buy Food");
            System.out.println("3. Delete Food");
            System.out.println("4. Exit");
            System.out.printf(">> ");
            choose = scan.nextInt();
            scan.nextLine();
            if(choose==1){
                showTransaction();
            }
            else if(choose==2){
                buyFood();

            }
            else if(choose == 3){
                deleteTransaction();
            }

        }while(choose!=4);
    }
    public void deleteTransaction(){
        Transaction dataTransaction = new Transaction();
        ArrayList<Transaction> transactions = dataTransaction.getAll();
        if(transactions.isEmpty()){
            System.out.println("NO TRANSACTION");
        }
        showTransaction();
        String chooseID;
        do{
            System.out.println("Choose transaction to delete [TRXXX]: ");
            chooseID = scan.nextLine();
        }while(new Transaction(chooseID).getById() == false);

        new Transaction(chooseID).deleteById();
        System.out.println("DELETED!!!");
    }

    public void viewTransaction(){
        Transaction dataTransaction = new Transaction();
        ArrayList<Transaction> transactions = dataTransaction.getAll();
        if(transactions.isEmpty()){
            System.out.println("NO TRANSACTION");
        }
        else{
            showTransaction();
            scan.nextLine();
        }
    }

    public void showTransaction(){
        Transaction dataTransaction = new Transaction();
        ArrayList<Transaction> transactions = dataTransaction.getAll();
        int index =1;
        for(Transaction a : transactions){
            Food food = getFoodByID(a.getFoodId());
            int foodPrice = food.getPrice();
            int tax = 0;
            if(food.getFoodType().equals("Quesadillas")){
                tax = 3000;
            }
            else if(food.getFoodType().equals("Taco")){
                tax = 5000;
            }
            int totalPrice = 0;
            totalPrice = (a.getQuantity() * foodPrice)+tax;
            System.out.printf("| %-3d | %-10s | %-20s | %-3d | IDR %-20d | IDR %-20d |\n", index++,a.getTransactionId(),food.getFoodName(),a.getQuantity(),food.getPrice(),totalPrice);
        }
    }

    public void buyFood(){
        showMenu();

        int foodId;
        int quantity;
        int tax = 0;

        do{
            System.out.println("Choose food to buy [1-10]: ");
            foodId = scan.nextInt();
        }while(foodId<1 || foodId>10);

        do{
            System.out.println("Quantity (more than 10): ");
            quantity = scan.nextInt();
        }while(quantity <=0);

        String id = "TR";
        for(int i = 0; i<3;i++){
            id = id + Integer.toString((int) (Math.random()*10));
        }
        scan.nextLine();

        Food orderedFood = getFoodByID(foodId);
        String foodName = orderedFood.getFoodName();
        int foodPrice = orderedFood.getPrice();
        if(orderedFood.getFoodType().equals("Quesadillas")){
            tax = 3000;
        }
        else if(orderedFood.getFoodType().equals("Taco")){
            tax = 5000;
        }

        int totalPrice;
        totalPrice = (quantity * foodPrice)+tax;

        System.out.println("TransactionDetail");
        System.out.println("=========================");
        System.out.printf("%-25s: %s\n","Transaction ID", id);
        System.out.printf("%-25s: %s\n","Food Name", foodName);
        System.out.printf("%-25s: %s\n","QTY", quantity);
        System.out.printf("%-25s: %s\n","Food Price", foodPrice);
        System.out.printf("%-25s: %s\n","Total after Tax", totalPrice);

        scan.nextLine();

        //insert to db
        Transaction newTransaction = new Transaction(id, foodId, quantity);
        newTransaction.addToDatabase();




    }

    private Food getFoodByID(int id){
        if(id <= 5 ){
            Quesadilla dataQuesadilla = new Quesadilla();
            ArrayList<Quesadilla> quesadillas = dataQuesadilla.getAll();
            return quesadillas.get(id-1);
        }
        else{
            Taco dataTaco = new Taco();
            ArrayList<Taco> tacos = dataTaco.getAll();
            return tacos.get(id-6);
        }
    }

    public void showMenu(){
        Quesadilla dataQuesadilla = new Quesadilla();
        ArrayList<Quesadilla> quesadillas = dataQuesadilla.getAll();
        for(Quesadilla a : quesadillas){
            System.out.printf("| %-3d | %-20s | %-15s | %-15s | %-15s | %-15s |\n", a.getFoodID(),a.getFoodName(),a.getFoodType(),a.getPrice(),"-",a.getDippingSauce());
        }
        Taco dataTaco = new Taco();
        ArrayList<Taco> tacos = dataTaco.getAll();
        for(Taco a : tacos){
            System.out.printf("| %-3d | %-20s | %-15s | %-15s | %-15s | %-15s |\n", a.getFoodID(),a.getFoodName(),a.getFoodType(),a.getPrice(),a.getShellType(),"-");
        }
    }

    public static void main(String[] args) {

        new Main();
    }
}

//    String id = "TR";
//    int TOTALTRANSACTION = 1;
//    id += String.format("%03d", TOTALTRANSACTION);
