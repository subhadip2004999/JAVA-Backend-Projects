# Hospital Management System

A Java-based hospital management console application that helps manage patients, doctors, and appointments using MySQL as the database.

## Features

- Add and view patients
- Add and view doctors
- Book appointments
- Prevent duplicate doctor booking on the same date
- Validate whether patient and doctor IDs exist before creating an appointment
- MySQL database integration using JDBC

## Project Structure

```text
Hospital Management System/
├── Appointment.java
├── Doctor.java
├── Main.java
├── Patient.java
├── pom.xml
├── mysql-connector-j-26.7.0.jar
└── README.md
```

## Tech Stack

- Java 25
- Maven
- MySQL
- JDBC MySQL Connector

## Prerequisites

Before running this project, make sure you have:

- Java JDK 25 or compatible version
- Maven installed
- MySQL Server running locally
- A database named `hospital`

## Database Setup

Create the required database and tables in MySQL:

```sql
CREATE DATABASE hospital;

USE hospital;

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Age INT,
    Gender VARCHAR(20),
    Phone VARCHAR(20)
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Specialization VARCHAR(100),
    Phone VARCHAR(20)
);

CREATE TABLE appointments (
    AppointmentId INT AUTO_INCREMENT PRIMARY KEY,
    PatientId INT,
    DoctorId INT,
    Date DATE
);
```

## Configuration

Update the database connection details in `Main.java` if needed:

```java
private static final String url = "jdbc:mysql://localhost:3306/hospital";
private static final String username = "root";
private static final String password = "your_password";
```

## Run the Project

### Using Maven

```bash
mvn clean compile
```

Then run the main class from your IDE or using a command similar to:

```bash
java -cp target/classes:$(mvn dependency:build-classpath -Dmdep.outputFile=cp.txt && cat cp.txt) com.hospitalmanagementsystem.Main
```

If using an IDE such as IntelliJ IDEA or Eclipse, simply run `Main.java`.

## Menu Options

When the program starts, it shows a menu with these options:

1. Add Patient
2. View Patient Table
3. Add Doctor
4. View Doctor Table
5. Book Appointment
6. Show Appointment Table
7. Exit

## Example Workflow

1. Add a patient
2. Add a doctor
3. Book an appointment by providing patient ID, doctor ID, and appointment date
4. View appointments to confirm bookings

## Notes

- This project is a console-based application, not a web application.
- The database name, username, and password must match your local MySQL setup.
- Appointment booking checks whether the selected doctor is already booked on the same date.

## License

This project is provided for learning and educational purposes.

## Author

Subhadip
