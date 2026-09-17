# Library Management System

A simple Java-based console application for managing books in a library. This project allows users to add, view, update, and delete book records using a menu-driven interface.

## Features

- Add a new book with title, author, ISBN, and publication year
- Display all books currently stored in the library
- Update an existing book by its ID/index
- Delete a book from the library
- Exit the application cleanly

## Project Structure

```text
Library Management System/
├── Book.java
├── Management.java
├── mainApp.java
├── pom.xml
├── application.properties
└── README.md
```

## Technologies Used

- Java
- Maven
- Spring Boot starter dependencies (configured in pom.xml)

## How to Run

### Prerequisites

- JDK 17 or later
- Maven

### Compile and run

From the project folder:

```bash
mvn compile
java -cp target/classes mypackage.mainApp
```

If you are using an IDE like IntelliJ IDEA or Eclipse, open the project and run `mainApp` directly.

## Example Menu

```text
||---------------------------------||
|| LIBRARY BOOKS MANAGEMENT SYSTEM ||
||---------------------------------||

1. Add books to library
2. Display all the books
3. Update books of it's ID
4. Delete books from library
5. Exit
```

## Notes

This project is a beginner-friendly Java application that demonstrates:

- object-oriented programming
- ArrayList usage
- user input handling with `Scanner`
- menu-based console application design

## License

This project is provided for educational purposes.
