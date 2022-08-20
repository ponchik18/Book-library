package application.menu;

import java.util.Scanner;

public abstract class Menu {

    protected String[] menuField;
    public abstract void complete();
    int printMenu(){
        System.out.println("+---------------------------+");

        for(String a:menuField){
            System.out.printf("| %-25s |\n",a );
        }
        System.out.println("+---------------------------+");
        int choice=0;
        try {
            System.out.print("Enter your choice: ");
            Scanner scanner=new Scanner(System.in);
            choice=scanner.nextInt();
            if(choice<0 || choice>menuField.length)
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("Error!, Try again");
            return printMenu();
        }
        return choice;
    }
}
