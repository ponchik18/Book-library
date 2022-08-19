package application.workingWithBooks;

import application.books.Book;
import application.books.BookLibrary;
import application.books.BookType;

import java.util.ArrayList;

public class Search {
    private BookLibrary library;

    public Search(BookLibrary library) {
        this.library = library;
    }

    public ArrayList<Book> searchByAuthor(String author){
        throw new UnsupportedOperationException();
    }
    public ArrayList<Book> searchByYear(int year){
        throw new UnsupportedOperationException();
    }
    public ArrayList<Book> searchByType(BookType bookType){
        throw new UnsupportedOperationException();
    }
    public Book searchByName(String name){
        throw new UnsupportedOperationException();
    }
}
