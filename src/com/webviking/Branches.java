package com.webviking;

import java.util.ArrayList;

public class Branches {
    private String name;
    private ArrayList<Customer> customers;

    public Branches(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }
    private Customer findCustomer(String customerName){
        for(int i =0; i < customers.size(); i++){
            if(customers.get(i).getName().equals(customerName)){
                return customers.get(i);
            }
        }
        return null;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }
    public boolean addTransaction(String customerName, double amount){
        Customer existing = findCustomer(customerName);
        if(existing != null){
            existing.addTransaction(amount);
            return true;
        }
        return false;
    }
}
