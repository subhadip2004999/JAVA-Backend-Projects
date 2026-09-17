# Banking Management System

A Java-based banking application that allows users to manage customer accounts using a MySQL database. The project includes account creation, viewing, deposits, withdrawals, balance checks, and KYC updates.

## Features

- Create new customer bank accounts
- View all bank accounts
- Deposit money into an account
- Withdraw money from an account
- Check account balance
- Update KYC status
- Exit the application

## Tech Stack

- Java 17
- Maven
- MySQL
- JDBC

## Project Structure

```text
Banking Management Sytem/
├── Account.java
├── Balance.java
├── Main.java
├── pom.xml
├── mysql-connector-java-8.0.18.jar
└── README.md
```

## Prerequisites

Before running the project, make sure you have:

- JDK 17 or later
- Apache Maven
- MySQL Server installed and running
- A MySQL database named `bank`

## Database Setup

The application connects to MySQL using:

```java
jdbc:mysql://localhost:3306/bank
```

with the username `root` and password `S12345s@`.

Create the database and the required table before running the app.

Example:

```sql
CREATE DATABASE bank;
USE bank;

CREATE TABLE bank_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    AccountNumber VARCHAR(50) UNIQUE,
    AccountType VARCHAR(20),
    Name VARCHAR(100),
    Phone VARCHAR(20),
    Email VARCHAR(100),
    Balance DOUBLE DEFAULT 0.0,
    Kyc VARCHAR(20) DEFAULT 'Pending'
);
```

## Run the Project

1. Open a terminal in the project directory.
2. Compile and run the project with Maven:

```bash
mvn clean compile
mvn exec:java
```

If `exec-maven-plugin` is not configured, run the application using your IDE or compile the project and execute the `Main` class manually.

## Application Menu

When the project runs, it shows a menu with:

1. Create New Bank Account
2. View All Bank Accounts
3. Deposit Money
4. Withdraw Money
5. Check Account Balance
6. Complete/Update KYC
7. Exit System

## Notes

- The project is a console-based banking management system.
- It uses direct JDBC queries for database operations.
- This is intended as a learning project for Java backend development and database integration.

## License

This project is for educational purposes.
