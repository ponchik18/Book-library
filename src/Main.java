import application.account.AccountProperty;
import application.account.AccountType;
import application.account.Admin;
import application.books.Book;
import application.books.BookLibrary;
import application.books.BookType;
import application.menu.Authorization;
import application.menu.Menu;
import application.menu.MenuAdmin;
import application.menu.MenuUser;
import application.workingWithBooks.BookWorkInUser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BookWorkInUser user;
        do {
            try {
                user = new Authorization().enterUsers();
                break;
            } catch (IllegalStateException e) {
                System.out.println("This account doesn't exist! Try again");
            }
        }while(true);
        Menu menu;
        if(user instanceof Admin)
            menu=new MenuAdmin();
        else
            menu=new MenuUser();
        menu.complete();
        /*FileReader fileReader=new FileReader("AccountFile.txt");
       AccountProperty accountProperty= new Authorization().ReadUserInfo(fileReader);
        System.out.println(accountProperty.getLogin());
        System.out.println(accountProperty.getPassword());
        System.out.println(accountProperty.getEmail());
        System.out.println(accountProperty.getAccountType());
        fileReader.close();*/
    }
}
