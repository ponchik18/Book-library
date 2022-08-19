package application.account;

import application.account.ParametrBook;
import application.books.Book;
import application.workingWithBooks.BookWorkInUser;

import java.util.ArrayList;

public class User implements BookWorkInUser {
    @Override
    public String printBooks(ArrayList<Book> catalogList) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean search(ParametrBook parametrBook) {
        return false;
    }
}
