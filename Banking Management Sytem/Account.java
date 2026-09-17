package com.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Account {
    private Connection con;
    private Scanner sc;

    public Account(Connection con, Scanner sc){
        this.con = con;
        this.sc = sc;
    }


    public void createAccounts(){
        System.out.println("\n| Create Customer Bank Account |\n");
        sc.nextLine();

        System.out.print("Enter Unique Account Number: ");
        String accountnumber = sc.nextLine();

        System.out.print("Enter Account Type (Current/Savings): ");
        String accounttype = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Customer Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Customer Email: ");
        String email = sc.nextLine();

        String query = "INSERT INTO bank_account (AccountNumber, AccountType, Name, Phone, Email) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, accountnumber);
            ps.setString(2, accounttype);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, email);
            int res = ps.executeUpdate();
            if (res>0){
                System.out.println("\nBank account created successfully for: Mr./Mrs "+name);
            }
            else{
                System.out.println("Failed to create bank account !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void viewAccounts(){
        String query = "SELECT * FROM bank_account";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nBank Accounts: ");
            System.out.println("+-------+-------------------------+-------------------+-------------------------+--------------------+-------------------------+--------------------+---------------+");
            System.out.println("| Id    | Account Number          | Account Type      | Customer Name           | Phone Number       | Email Address           | Bank Balance       | KYC Status    |");
            System.out.println("+-------+-------------------------+-------------------+-------------------------+--------------------+-------------------------+--------------------+---------------+");
            

            while(rs.next()){
                int id = rs.getInt("id");
                String accountnumber = rs.getString("AccountNumber");
                String accounttype = rs.getString("AccountType");
                String name = rs.getString("Name");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                Double balance = rs.getDouble("Balance");
                String kyc = rs.getString("Kyc");

                System.out.printf("| %-5d | %-23s | %-17s | %-23s | %-18s | %-23s | %-18.2f | %-13s |\n", id, accountnumber, accounttype, name, phone, email, balance, kyc);
                System.out.println("+-------+-------------------------+-------------------+-------------------------+--------------------+-------------------------+--------------------+---------------+");
            }

        } catch (Exception e) {
        }
    }

}
