# ATM Interface

A simple Java-based ATM simulation built with Spring Boot and Maven. This project demonstrates basic banking operations such as checking the account balance, depositing money, withdrawing money, and exiting the ATM after PIN validation.

## Features

- PIN authentication
- View current balance
- Deposit funds
- Withdraw funds
- Basic validation for invalid amounts and insufficient balance
- Console-based menu interface

## Project Structure

```text
ATM Interface/
├── AtmInterfaceApplication.java
├── BankAccount.java
├── application.properties
├── pom.xml
└── README.md
```

## Tech Stack

- Java 17
- Spring Boot 4.1.1
- Maven

## How to Run

1. Open the project folder:

```bash
cd "ATM Interface"
```

2. Build the project:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn spring-boot:run
```

4. Enter the PIN when prompted. The default PIN in the project is:

```text
1234
```

## Menu Options

1. Show Balance
2. Deposit Money
3. Withdraw Money
4. Exit

## Notes

This is a beginner-friendly ATM console application and is mainly intended for learning Java programming and basic banking logic.

## Author

Subhadip Roy
