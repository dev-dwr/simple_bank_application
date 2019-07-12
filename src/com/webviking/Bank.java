package com.webviking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branches> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }
    private Branches findBranch(String name){
        for(int i =0; i < branches.size(); i++){
            if(branches.get(i).getName().equals(name)){
                return branches.get(i);
            }
        }
        return null;
    }
    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branches.add(new Branches(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branches existingBranch = findBranch(branchName);
        if(existingBranch != null){
            return existingBranch.newCustomer(customerName,initialAmount);
        }
        return false;
    }
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branches existingBranch = findBranch(branchName);
        if(existingBranch != null){
            return existingBranch.addTransaction(customerName,amount);
        }
        return false;
    }
    public  boolean listCustomers(String branchName, boolean showTransactions ){
        Branches branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Customers details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i =0; i< branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if(showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j =0; j<transactions.size(); j++){
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }
}


















