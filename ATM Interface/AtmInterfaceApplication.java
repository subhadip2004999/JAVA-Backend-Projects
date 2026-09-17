package com.example.atm_interface;

import java.util.Scanner;

public class AtmInterfaceApplication {
	private Scanner sc;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount account = new BankAccount(500.00,1234);

		System.out.println("\n\n||-----------------------||");
		System.out.println("|| ATM INTERFACE in java ||");
		System.out.println("||-----------------------||\n");
		System.out.print("Enter your pin number: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		boolean status = account.getPinNumber(number);
		if (status == true) {
			System.out.println("\nPin Number matched successfully");
			while(true){
				System.out.println("\n\n||---------------------||");
				System.out.println("|| WELCOME TO JAVA ATM ||");
				System.out.println("||---------------------||\n");
				System.out.println("1. Show Balance");
				System.out.println("2. Deposit Money");
				System.out.println("3. Withdraw Money");
				System.out.println("4. Exit");
				System.out.print("\nEnter your choice: ");

			try{
				int choice = sc.nextInt();
				sc.nextLine();

				switch(choice){

					case 1:
						System.out.println("\n||--------------------||");
						System.out.println("|| ATM - SHOW BALANCE ||");
						System.out.println("||--------------------||");
						System.out.println("\nYour Current Balance is: "+account.getBalance());
						sc.nextLine();
						break;

					case 2:
						System.out.println("\n||---------------------||");
						System.out.println("|| ATM - DEPOSIT MONEY ||");
						System.out.println("||---------------------||");
						System.out.print("\nEnter the amount to be deposited: ");
						double amount1 = sc.nextInt();
						sc.nextLine();
						account.deposit(amount1);
						System.out.println("The current balance is: "+ account.getBalance());
						sc.nextLine();
						break;

					case 3:
						System.out.println("\n||----------------------||");
						System.out.println("|| ATM - WITHDRAW MONEY ||");
						System.out.println("||----------------------||");
						System.out.print("\nEnter the amount to be withdrawl: ");
						double amount2 = sc.nextInt();
						sc.nextLine();
						account.withdraw(amount2);
						System.out.println("The current balance is: "+ account.getBalance());
						sc.nextLine();
						break;

					case 4:
						System.out.println("\nATM exiting.....");
						System.out.println("THANK YOU....\n");
						return;

					default:
						System.out.println("\nEnter Valid choice !!");
						break;
				}
			}
		  catch(Exception e){
				System.out.println("\nEXCEPTION HANDLING: Only enter numbers in choice\n");
				return;
			}
		}
		}
		else {
			System.out.println("\nPin number does not matched!! \n\nEXITING PROGRAM !!\n");
		}
	}


	private void depositDone(){
		
	}

}
