package com.example.number_game;

import java.util.Random;
import java.util.Scanner;

public class NumberGameApplication {

public static void main(String[] args) {

	NumberGameApplication game = new NumberGameApplication();

	Scanner sc = new Scanner(System.in);
	while(true){
		System.out.println("\n||---------------------------||");
		System.out.println("|| CAN YOU GUESS THE NUMBER? ||");
		System.out.println("||---------------------------||\n");
		System.out.println("1. Start the game");
		System.out.println("2. Exit the game");
		System.out.print("\nEnter your choice (1/2): ");
		int choice = sc.nextInt();
		sc.nextLine();

		switch(choice){
			case 1:
				game.startGame();
				break;

			case 2:
				System.out.println("\nGame Exited\n");
				return;

			default:
				System.out.println("\nEnter Valid choice\n");
				break;
		}


	}

}




public void startGame(){
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	int randomnumber = random.nextInt(1,100);
	System.out.println("\n||--------------------------------||");
	System.out.println("|| GAME STARTED. GUESS THE NUMBER ||");
	System.out.println("||--------------------------------||\n");
	System.out.print("\nGuess the number: ");
		int points = 50;
		int score = points;
		int usernumber = sc.nextInt();
		sc.nextLine();
		while (randomnumber != usernumber){
			int temp = usernumber;
			if(temp>randomnumber){
				System.out.println("Your number is too high");
			}
			else{
				System.out.println("Your number is too low");
			}
			System.out.print("\nGuess again: ");
			usernumber = sc.nextInt();
			sc.nextLine();
			score = points --;
			}
		System.out.println("\n\nCongratulations. Your guess is right the number is: "+ randomnumber+"\n");
		System.out.println("Your Score is: "+score+" out of 50");
		sc.nextLine();
			
}

}
