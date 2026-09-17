package mypackage;

import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create object man for the class management
		Management man = new Management();
		
		try {
			// running the program till the user exit
			while(true){
				// library book management system interface
			System.out.println("\n\n||---------------------------------||");
			System.out.println("|| LIBRARY BOOKS MANAGEMENT SYSTEM ||");
			System.out.println("||---------------------------------||\n");
			System.out.println("1. Add books to library");
			System.out.println("2. Display all the books");
			System.out.println("3. Update books of it's ID");
			System.out.println("4. Delete books from library");
			System.out.println("5. Exit");
			System.out.print("\nEnter your choice: ");
			// taking choice from the user
			int choice = sc.nextInt();
			sc.nextLine();

			// apply switch case for options
			switch(choice){

				case 1:
					// call the method of adding books
					System.out.println("\n\n||-----------------------------||");
					System.out.println("|| ADD ANY BOOK TO THE LIBRARY ||");
					System.out.println("||-----------------------------||\n");
					man.addBook();
					sc.nextLine();
					break;

				case 2:
					// call the method of display books
					System.out.println("\n\n||-------------------------------||");
					System.out.println("|| LISTS OF BOOKS IN THE LIBRARY ||");
					System.out.println("||-------------------------------||\n");
					man.listBook();
					sc.nextLine();
					break;

				case 3:
					// call the method of updating book
					System.out.println("\n\n||--------------------------------||");
					System.out.println("|| UPDATE ANY BOOK IN THE LIBRARY ||");
					System.out.println("||--------------------------------||\n");
					man.updateBook();
					sc.nextLine();
					break;

				case 4:
					// call the method of deleting books
					System.out.println("\n\n||--------------------------------||");
					System.out.println("|| DELETE ANY BOOK IN THE LIBRARY ||");
					System.out.println("||--------------------------------||\n");
					man.deleteBook();
					sc.nextLine();
					break;

				case 5:
					// exit the prograb by breaking while loop
					System.out.println("\n\nPROGRAM EXITED SUCCESSFULLY\n");
					return;

				default:
					// if user give wrong input then it handels that
					System.out.println("\nEnter valid choice (1-5)\n");
					break;
					 
			}
		}
		} catch (Exception e) {
			// exception handling
			System.out.println("\nInvalid input from the user\n");
			// print all the exceptions
			e.printStackTrace();
		}
		
	}

}
