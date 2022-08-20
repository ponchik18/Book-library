package application.menu;

public class MenuUser extends Menu{
    public MenuUser(){
        menuField=new String[]{"1)Get book list","2)Search book", "3)Take a book","4)Return book", "5)Exit"};
    }
    @Override
    public void complete() {
        printMenu();
    }


}
