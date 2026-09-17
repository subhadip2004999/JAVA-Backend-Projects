package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "S12345s@";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1. Establish Database Connection
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println(" Connected to Banking Database successfully!");

            // 2. Instantiate Helper Classes
            Account accountManager = new Account(con, sc);
            Balance balanceManager = new Balance(con, sc);

            boolean isRunning = true;

            // 3. Application Menu Loop
            while (isRunning) {
                System.out.println("\n===========================================");
                System.out.println("         BANK MANAGEMENT SYSTEM            ");
                System.out.println("===========================================");
                System.out.println("1. Create New Bank Account");
                System.out.println("2. View All Bank Accounts");
                System.out.println("3. Deposit Money");
                System.out.println("4. Withdraw Money");
                System.out.println("5. Check Account Balance");
                System.out.println("6. Complete/Update KYC");
                System.out.println("7. Exit System");
                System.out.println("-------------------------------------------");
                System.out.print("Enter your choice (1-7): ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number between 1 and 7.");
                    sc.next(); // Clear invalid token
                    continue;
                }

                int choice = sc.nextInt();

                // 4. Switch-Case Menu Routing
                switch (choice) {
                    case 1:
                        accountManager.createAccounts();
                        System.out.println();
                        sc.nextLine();
                        break;

                    case 2:
                        accountManager.viewAccounts();
                        System.out.println();
                        sc.nextLine();
                        break;

                    case 3:
                        balanceManager.depositBalance();
                        System.out.println();
                        sc.nextLine();
                        break;

                    case 4:
                        balanceManager.withdrawBalance();
                        System.out.println();
                        sc.nextLine();
                        break;

                    case 5:
                        balanceManager.showBalance();
                        System.out.println();
                        sc.nextLine();
                        break;

                    case 6:
                        balanceManager.doneKyc();
                        System.out.println();
                        sc.nextLine();
                        break;

                    case 7:
                        isRunning = false;
                        System.out.println("\nThank you for using the Banking Management System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select an option between 1 and 7.");
                        System.out.println();
                        sc.nextLine();
                        break;
                }
            }

            // Clean up resources
            con.close();
            sc.close();

        } catch (SQLException e) {
            System.err.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }
}