package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Balance {
    
    private Connection con;
    private Scanner sc;

    public Balance(Connection con, Scanner sc) {
        this.con = con;
        this.sc = sc;
    }

    public void depositBalance() {
        System.out.println("\n| Deposit Money to Customer's Bank Balance |\n");
        
        sc.nextLine(); // Clear buffer
        
        System.out.print("Enter Customer's Account Number: ");
        String accountnumber = sc.nextLine();
        
        System.out.print("Enter Amount to Deposit: ");
        double depositamount = sc.nextDouble();

        if (depositamount <= 0.0) {
            System.out.println("Invalid amount! Deposit must be greater than 0.00");
            return;
        }

        String query1 = "SELECT Balance FROM bank_account WHERE AccountNumber = ?";
        String query2 = "UPDATE bank_account SET Balance = ? WHERE AccountNumber = ?";

        try {
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setString(1, accountnumber); 
            
            ResultSet rs = ps1.executeQuery();
            
            if (rs.next()) {
                double currentbalance = rs.getDouble("Balance");
                double newbalance = currentbalance + depositamount;

                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.setDouble(1, newbalance);
                ps2.setString(2, accountnumber);
                
                int result = ps2.executeUpdate();
                if (result > 0) {
                    System.out.println("\nAmount deposited to Account Number: " + accountnumber);
                    System.out.printf("Previous Balance: $%.2f%n", currentbalance);
                    System.out.printf("Deposited Amount: $%.2f%n", depositamount);
                    System.out.printf("Current Balance : $%.2f%n", newbalance);
                } else {
                    System.out.println("Failed to update balance!");
                }
            } else {
                System.out.println("Account Number not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdrawBalance() {
        System.out.println("\n| Withdraw Money from Customer's Bank Balance |\n");
        
        sc.nextLine(); // Clear buffer
        
        System.out.print("Enter Customer's Account Number: ");
        String accountnumber = sc.nextLine();
        
        System.out.print("Enter Amount to Withdraw: ");
        double withdrawamount = sc.nextDouble();

        if (withdrawamount <= 0.0) {
            System.out.println("Invalid amount! Withdrawal must be greater than 0.00");
            return;
        }

        String query1 = "SELECT Balance FROM bank_account WHERE AccountNumber = ?";
        String query2 = "UPDATE bank_account SET Balance = ? WHERE AccountNumber = ?";

        try {
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setString(1, accountnumber);
            ResultSet rs = ps1.executeQuery();
            
            if (rs.next()) {
                Double currentbalance = rs.getDouble("Balance");

                if (withdrawamount > currentbalance) {
                    System.out.println("Failed: Insufficient Balance!");
                    System.out.printf("Current Balance: Rs. %.2f%n", currentbalance);
                } else {
                    double newbalance = currentbalance - withdrawamount;

                    PreparedStatement ps2 = con.prepareStatement(query2);
                    ps2.setDouble(1, newbalance);
                    ps2.setString(2, accountnumber);
                    
                    int result = ps2.executeUpdate();
                    if (result > 0) {
                        System.out.println("\nAmount withdrawn from Account Number: " + accountnumber);
                        System.out.printf("Previous Balance: Rs. %.2f%n", currentbalance);
                        System.out.printf("Withdrawn Amount: Rs. %.2f%n", withdrawamount);
                        System.out.printf("Current Balance : Rs. %.2f%n", newbalance);
                    } else {
                        System.out.println("Failed to update balance!");
                    }
                }
            } else {
                System.out.println("Account Number not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBalance() {
        System.out.println("\n| Check Customer's Bank Balance |\n");
        
        sc.nextLine(); // Clear buffer
        
        System.out.print("Enter Customer's Account Number: ");
        String accountnumber = sc.nextLine();

        String query = "SELECT * FROM bank_account WHERE AccountNumber = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accountnumber);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Name");
                String accountType = rs.getString("AccountType");
                double balance = rs.getDouble("Balance");
                String kyc = rs.getString("Kyc");

                System.out.println("\n-------------------------------------------");
                System.out.println("           ACCOUNT BALANCE DETAILS         ");
                System.out.println("-------------------------------------------");
                System.out.println("Account Number : " + accountnumber);
                System.out.println("Customer Name  : " + name);
                System.out.println("Account Type   : " + accountType);
                System.out.printf("Current Balance: Rs. %.2f%n", balance);
                System.out.println("KYC Status     : " + kyc);
                System.out.println("-------------------------------------------");
            } else {
                System.out.println("Account Number not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void doneKyc() {
        System.out.println("\n| Update Account KYC Status |\n");
        
        sc.nextLine(); // Clear buffer
        
        System.out.print("Enter Customer's Account Number: ");
        String accountnumber = sc.nextLine();

        String selectQuery = "SELECT Name, Kyc FROM bank_account WHERE AccountNumber = ?";
        String updateQuery = "UPDATE bank_account SET Kyc = 'Verified' WHERE AccountNumber = ?";

        try {
            PreparedStatement ps1 = con.prepareStatement(selectQuery);
            ps1.setString(1, accountnumber);
            
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Name");
                String currentKyc = rs.getString("Kyc");

                if ("Verified".equalsIgnoreCase(currentKyc)) {
                    System.out.println("KYC is already completed/verified for Account: " + accountnumber + " (" + name + ").");
                } else {
                    PreparedStatement ps2 = con.prepareStatement(updateQuery);
                    ps2.setString(1, accountnumber);

                    int rowsAffected = ps2.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Success: KYC updated to 'Verified' for Account: " + accountnumber + " (" + name + ").");
                    } else {
                        System.out.println("Failed to update KYC status!");
                    }
                }
            } else {
                System.out.println("Account Number not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}