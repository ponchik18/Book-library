package application.workingWithBooks;

import application.account.ParametrBook;
import application.books.Book;

import java.util.ArrayList;

public interface BookWorkInUser {

    String printBooks(ArrayList<Book> catalogList);
    boolean search(ParametrBook parametrBook);
}
