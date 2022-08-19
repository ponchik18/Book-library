package application.account;

import application.books.Book;
import application.workingWithBooks.BookWorkInAdmin;
import application.workingWithBooks.BookWorkInUser;

import java.util.ArrayList;

public class Admin implements BookWorkInAdmin, BookWorkInUser {
    public Admin() {
        super();
    }


    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBook(String bookName) {
        return false;
    }

    @Override
    public boolean change(ParametrBook parametrBook) {
        return false;
    }


    @Override
    public String printBooks(ArrayList<Book> catalogList) {
        return null;
    }

    @Override
    public boolean search(ParametrBook parametrBook) {
        return false;
    }
}
