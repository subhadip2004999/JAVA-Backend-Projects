package mypackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    
    // Making a arraylist which takes class Book as wrapperclass
    public static ArrayList<Book> booklist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    // Method to add books
    public void addBook(){
        System.out.print("Enter Title of the Book: ");
        String title = sc.nextLine();
        System.out.print("Enter Author of the Book: ");
        String author = sc.nextLine();
        System.out.print("Enter ISBN of the Book: ");
        int isbn = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Publication Year of the Book: ");
        int publicationyear = sc.nextInt();
        sc.nextLine();

        // append the inputs to the list which calls the constructor Book
        booklist.add(new Book(title,author,isbn,publicationyear));
        System.out.println("\nThe book ("+title+") is successfully added to the List !!");

    }


    // Method to list all books
    public void listBook(){
        System.out.println("The current list of Books: \n");

        // in a loop if the list is empty
        if(booklist.isEmpty()){
            System.out.println("There are no books. The list is empty");
        }

        // is not empty then it iterate till the size of the list
        for(int i=0; i<booklist.size(); i++){
            Book book = booklist.get(i);
            // print the book contents
            System.out.println((i+1)+". ID of the Book: "+i+"\n   Title: "+book.getTitle()+"\n   Author: "+book.getAuthor()+"\n   ISBN: "+book.getISBN()+"\n   Publication Year: "+book.getPublicationyear());
            System.out.println();
            System.out.println();
        }
    }


    // Method to update the book
    public void updateBook(){
        System.out.print("Enter the ID of the book to be updated:");
        // store the input in index
        int index = sc.nextInt();
        sc.nextLine();

        if (index <0 && booklist.isEmpty()){
            System.out.println("\nBook not found");
        }

        System.out.println("\n UPDATE THE BOOK CONTENTS \n");
        // taking new inputs from users
        System.out.print("Enter New Title of the Book: ");
        String title = sc.nextLine();
        System.out.print("Enter New Author of the Book: ");
        String author = sc.nextLine();
        System.out.print("Enter New ISBN of the Book: ");
        int isbn = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Publication Year of the Book: ");
        int publicationyear = sc.nextInt();
        sc.nextLine();

        // set the book contents in the index as id
        booklist.set(index, new Book(title,author,isbn,publicationyear));
        System.out.println("\nBook is Successfully updated for the ID: "+index+" !!");

    }


    // Method to delete the books
    public void deleteBook(){
        System.out.print("Enter the ID of the book to be deleted: ");
        // take the input as id but it is index
        int index = sc.nextInt();
        sc.nextLine();

        if (index <0 && booklist.isEmpty()){
            System.out.println("\nBook not found");
        }
        // removing the book of the index number
        booklist.remove(index);
        System.out.println("\nBook is Successfully removed form the list !!");
    }
}
