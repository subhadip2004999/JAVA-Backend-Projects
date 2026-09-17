# Stock Trading Platform

A console-based stock trading application built with Java, JDBC, MySQL, and Spring Boot's Maven project structure. The application allows users to create accounts, log in, view available market data, manage a portfolio, and record stock buy and sell transactions.

> **Project status:** This is a command-line application backed by a local MySQL database. It is not currently exposed as a REST API or web application.

## Features

- User registration with name, email, and password
- User login and authentication
- Display available stocks and prices
- Buy stocks by symbol and quantity
- Sell stocks by symbol and quantity
- View account balance and total stock value
- View transaction history
- Persistent data storage using MySQL and JDBC

## Technology Stack

- **Language:** Java 17
- **Build tool:** Maven
- **Database:** MySQL
- **Database access:** JDBC
- **Project framework:** Spring Boot project structure
- **JDBC driver:** MySQL Connector/J

## Project Structure

```text
Stock Trading Platform/
├── mainApp.java              # Console application entry point and menus
├── Users.java                # User registration and login operations
├── Stocks.java               # Market-data retrieval
├── Portfolio.java            # Portfolio, buy, sell, and transaction operations
├── application.properties   # Application configuration
└── pom.xml                   # Maven project configuration
```

All Java classes currently use the `mypackage` package.

## Prerequisites

Install the following before running the application:

- Java Development Kit (JDK) 17 or later
- Maven 3.8 or later
- MySQL Server 8.0 or later

## Database Setup

Create the database used by the application:

```sql
CREATE DATABASE trading_stocks;
USE trading_stocks;
```

Create the required tables:

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    balance DECIMAL(15, 2) DEFAULT 0.00,
    stockvalue DECIMAL(15, 2) DEFAULT 0.00
);

CREATE TABLE stocks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    symbol VARCHAR(20) NOT NULL UNIQUE,
    companyname VARCHAR(150) NOT NULL,
    price DECIMAL(15, 2) NOT NULL
);

CREATE TABLE portfolio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    useremail VARCHAR(150) NOT NULL,
    stocksymbol VARCHAR(20) NOT NULL,
    buyorsell VARCHAR(10) NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (useremail) REFERENCES users(email)
);
```

Add sample market data if needed:

```sql
INSERT INTO stocks (symbol, companyname, price) VALUES
    ('AAPL', 'Apple Inc.', 190.00),
    ('MSFT', 'Microsoft Corporation', 420.00),
    ('GOOGL', 'Alphabet Inc.', 175.00);
```

### Configure the database connection

The connection settings are currently defined in `mainApp.java`. Update the URL, username, and password for your local MySQL installation before running the project:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/trading_stocks";
private static final String DB_USER = "your_mysql_username";
private static final String DB_PASSWORD = "your_mysql_password";
```

Do not commit real database credentials to source control. For production use, move these values to environment variables or a secure configuration system.

## Build and Run

From the project directory, run:

```bash
cd "Stock Trading Platform"
mvn clean package
java -cp "target/classes:target/dependency/*" mypackage.mainApp
```

On Windows, use `;` instead of `:` in the Java classpath:

```bat
java -cp "target/classes;target/dependency/*" mypackage.mainApp
```

Alternatively, run the application from an IDE as the `mypackage.mainApp` class after Maven dependencies have been downloaded.

## Application Flow

1. Start the application.
2. Create a new user account or log in with an existing account.
3. Choose an action from the trading menu:
   - Display market data
   - View portfolio and transaction history
   - Buy stocks
   - Sell stocks
4. Exit the application when finished.

## Important Notes

- Passwords are currently stored as plain text. Use password hashing, such as BCrypt, before using this application in a real environment.
- Validate that a user has sufficient balance before completing a buy transaction and sufficient holdings before completing a sell transaction.
- Use database transactions so portfolio records and user balances are updated atomically.
- Use try-with-resources to close JDBC statements and result sets safely.
- Keep database credentials outside the source code.
- The current implementation tracks aggregate stock value rather than individual holdings per stock symbol; a production implementation should maintain symbol-level quantities.

## License

No license has been specified for this project yet.
