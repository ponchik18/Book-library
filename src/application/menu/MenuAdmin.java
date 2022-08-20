package application.menu;

import java.util.Scanner;

public class MenuAdmin extends Menu{
    public MenuAdmin(){
        menuField=new String[]{"1)Get book list","2)Modify book info","3)Add new book","4)Delete book", "5)Exit"};
    }
    @Override
    public void complete() {
        printMenu();
    }




}
