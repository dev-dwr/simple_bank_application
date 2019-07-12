package com.webviking;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Santander");
        bank.addBranch("Wroclaw");

        bank.addCustomer("Wroclaw", "David", 200.00);
        bank.addCustomer("Wroclaw", "Ann", 123.32);
        bank.addCustomer("Wroclaw", "Seb", 33.33);

        bank.addBranch("Strzegom");
        bank.addCustomer("Strzegom", "Karol", 133.12);

        bank.addCustomerTransaction("Wroclaw", "David", 123.00);
        bank.addCustomerTransaction("Wroclaw", "David", 12.00);
        bank.addCustomerTransaction("Wroclaw", "Ann", 23.00);

        bank.listCustomers("Wroclaw",true);
        bank.listCustomers("Strzegom", true);

        //Simple tests

        bank.addBranch("Cracow");
        if(!bank.addCustomer("Cracow","Kuba",4.4)){
            System.out.println("Error Cracow branch does not exist");
        }
        if(!bank.addBranch("Wroclaw")){
            System.out.println("Wroclaw branch already exist");
        }
        if(!bank.addCustomerTransaction("Wroclaw", "Fedor", 33.33)){
            System.out.println("customer does not exists");
        }
        if(!bank.addCustomer("Wroclaw", "David", 12.21)){
            System.out.println("customer david exist");
        }
    }
}
