package mypackage;

public class Book {
    // book is a entity where these are the parameters of a book
    private String title;
    private String author;
    private int isbn;
    private int publicationyear;

    // Constructor which is parametarised
    public Book(String title, String author, int isbn, int publicationyear){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationyear = publicationyear;
    }

    // A method which give title of the book
    public String getTitle(){
        return title;
    }

    // A method which give author of the book
    public String getAuthor(){
        return author;
    }

    // A method which give ISBN of the book
    public int getISBN(){
        return isbn;
    }

    // A method which give year of publication of the book
    public int getPublicationyear(){
        return publicationyear;
    }
}
