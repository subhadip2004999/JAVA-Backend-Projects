# Number Guess Game

A simple console-based number guessing game written in Java. The game generates a random number and guides the player with hints until the correct number is guessed.

## Features

- Start a new game from an interactive menu.
- Guess a randomly generated number between 1 and 99.
- Receive a hint when a guess is too high or too low.
- Track a score out of 50.
- Exit the game from the main menu.

## Technologies Used

- Java 17
- Maven
- Spring Boot project structure

## Project Structure

```text
Number Guess Game/
├── NumberGameApplication.java
├── application.properties
└── pom.xml
```

## Prerequisites

- Java Development Kit (JDK) 17 or later
- Apache Maven 3.8 or later

Verify your installations:

```bash
java -version
mvn -version
```

## Running the Application

1. Open a terminal in this directory:

   ```bash
   cd "Number Guess Game"
   ```

2. Compile the project:

   ```bash
   mvn clean compile
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

Alternatively, run the `main` method in `NumberGameApplication.java` from your IDE.

## How to Play

1. Select `1` to start the game.
2. Enter a number when prompted.
3. Use the hints to adjust your next guess:
   - **Your number is too high** means guess a smaller number.
   - **Your number is too low** means guess a larger number.
4. Continue until you guess the correct number.
5. Select `2` from the menu to exit.

## Configuration

The application name is configured in `application.properties`:

```properties
spring.application.name=number_game
```

## License

This project is available for learning and personal use. No license has been specified yet.
