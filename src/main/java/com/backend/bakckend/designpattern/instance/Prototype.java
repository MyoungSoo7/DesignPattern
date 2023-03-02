package com.backend.bakckend.designpattern.instance;


import java.util.ArrayList;

class Book{
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

class BookShelf implements Cloneable{
    private ArrayList<Book> books;

    public BookShelf() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BookShelf bookShelf = new BookShelf();
        for(Book book : books)
            bookShelf.addBook(new Book(book.getAuthor(), book.getTitle()));

        return bookShelf;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String toString() {
        return books.toString();
    }
}



public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {

        BookShelf bookShelf = new BookShelf();

        bookShelf.addBook(new Book("author1", "title1"));
        bookShelf.addBook(new Book("author2", "title2"));
        bookShelf.addBook(new Book("author3", "title3"));

        BookShelf bookShelf2 = (BookShelf) bookShelf.clone();

        System.out.println(bookShelf);
        System.out.println(bookShelf2);

        bookShelf.getBooks().get(0).setAuthor("author4");
        bookShelf.getBooks().get(0).setTitle("title4");

        System.out.println(bookShelf.toString());
        System.out.println(bookShelf2.toString());
    }

}
