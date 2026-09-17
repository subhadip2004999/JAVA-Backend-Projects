# Java GUI Based Projects

This folder contains a small collection of Java Swing GUI applications built for learning and practice. Each program demonstrates a different kind of desktop UI interaction using Java's `javax.swing` toolkit.

## Included Projects

- Calculator
  - A calculator with a modern swing interface.
  - Supports basic arithmetic operations and display formatting.

- Tic Tac Toe
  - A classic 3x3 board game with turn-based play.
  - Detects win conditions and draws.

- Voter Check
  - A simple age validation form for checking voter eligibility.

- app.java
  - A launcher class that starts the Tic Tac Toe game.

## Project Structure

```text
Java GUI based/
├── Calculator.java
├── TicTacToe.java
├── VoterCheck.java
├── app.java
└── README.md
```

## Requirements

- Java JDK 8 or later
- A Java IDE such as VS Code, IntelliJ IDEA, or Eclipse, or command-line compilation using `javac`

## How to Run

### 1. Calculator

```bash
javac Calculator.java
java Calculator
```

### 2. Tic Tac Toe

```bash
javac app.java TicTacToe.java
java app
```

### 3. Voter Check

```bash
javac VoterCheck.java
java VoterCheck
```

Note: `VoterCheck.java` currently contains the UI logic for the voter eligibility form and can be compiled/executed directly if it is adapted with a `main` method.

## Notes

These programs are beginner-friendly examples meant to practice:

- Swing components (`JFrame`, `JPanel`, `JButton`, `JLabel`, `JTextField`)
- Event handling with `ActionListener`
- UI layout management
- Game logic and simple validation

## Author

Created by Subhadip
