package com.example.atm_interface;

public class BankAccount {
    private double balance;
    private int pinnumber;

    public BankAccount(double initialBalance, int pinnumber) {
        this.balance = initialBalance;
        this.pinnumber = pinnumber;
    }

    public boolean getPinNumber(int number){
        if(number==pinnumber){
            return true;
        }
        else{
            return false;
        }

    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if (amount>0){
            balance = balance + amount;
            System.out.println("\nThe deposited amount is: "+ amount);
        }
        else{
            System.out.println("\nInvalid amount !!");
        }
    }

    public void withdraw(double amount){
        if (amount>0){
            if(amount>balance){
                System.out.println("\nInsufficient funds to be withdrawn !!");
            }
            else{
                balance = balance - amount;
                System.out.println("\nThe Withdrawn amount is: "+ amount);
            }
        }
        else{
            System.out.println("\nInvalid amount !!");
        }
    }

}
