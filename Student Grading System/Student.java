package com.example.student_grade_calculator;

import java.util.Scanner;

public class Student {
    public void gradeCalculator(){
   		Scanner sc = new Scanner(System.in);

		System.out.println("\n## Enter student's name and marks ##\n");
		System.out.print("Please enter the student's name: ");
		String name = sc.nextLine();
		System.out.print("Enter English Marks: ");
		int english = sc.nextInt();
		System.out.print("Enter Math Marks: ");
		int math = sc.nextInt();
		System.out.print("Enter Science Marks: ");
		int science = sc.nextInt();
		System.out.print("Enter History Marks: ");
		int history = sc.nextInt();
		System.out.print("Enter Geography Marks: ");
		int geography = sc.nextInt();

		System.out.println("\n## Show Student's Summary ##\n");
		sc.nextLine();
		int gotMarks = english + math + science + history + geography;
		int totalMarks = 500;
		double averagePercentage = gotMarks / 5.0;
		

		System.out.println("Student Name: " + name);
		System.out.println("Total Marks Obtained: " + gotMarks + " out of " + totalMarks);
		System.out.println("Average Percentage: " + averagePercentage + "%");
		System.out.println("Grade: " + getGrade(averagePercentage));

	}


	public String getGrade(double percentage){
		if(percentage >= 90){
			return "A";
		}else if(percentage >= 80){
			return "B";
		}else if(percentage >= 70){
			return "C";
		}else if(percentage >= 60){
			return "D";
		}else{
			return "F";
		}
	}
}
