package application.workingWithBooks;

import application.account.ParametrBook;
import application.books.Book;

public interface BookWorkInAdmin {
     boolean addBook(Book book);

     boolean deleteBook(String bookName);

    boolean change(ParametrBook parametrBook);

}
