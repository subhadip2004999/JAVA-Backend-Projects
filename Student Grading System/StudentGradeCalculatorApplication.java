package com.example.student_grade_calculator;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentGradeCalculatorApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();

		while(true){
			System.out.println("\n\n|| Welcome to the Student Grade Calculator ||\n");
			System.out.println("1. Run the Student Grade Calculator");
			System.out.println("2. Exit the Application");
			System.out.print("\nPlease select an option (1 or 2): ");
			 // Consume the newline character

			try {
				int option = sc.nextInt();
				sc.nextLine();
				
				switch(option){
					case 1:
						student.gradeCalculator();
						sc.nextLine(); // Consume the newline character after the gradeCalculator method
						break;
					case 2:
						System.out.println("\nExiting the application. Goodbye!\n");
						return;
					default:
						System.out.println("\nInvalid option. Please select 1 or 2.\n");
						sc.nextLine(); // Consume the invalid input
						break;
					
				}
			} catch (Exception e) {
				System.out.println("\nInvalid input. Please enter a valid option.\n");
				sc.nextLine(); // Consume the invalid input
			}
		}	
	}
}
