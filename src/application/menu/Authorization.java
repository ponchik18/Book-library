package application.menu;

import application.account.AccountProperty;
import application.account.AccountType;
import application.account.PasswordHash;
import application.workingWithBooks.BookWorkInUser;

import javax.swing.text.html.Option;
import java.io.*;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authorization {
    private String fileWithAccount="AccountFile.txt";

    private AccountProperty getUsersInfo(){
        System.out.print("Enter your login: ");
        Scanner scanner=new Scanner(System.in);
        String login=scanner.nextLine();
        System.out.print("Enter your password: ");
        String password=scanner.nextLine();
        PasswordHash hash=new PasswordHash(password);
        String str=new String();
        for(byte a:hash.getHashByte()){
            str+=a;
        }
        return new AccountProperty(login, str);
    }
    private Optional<BookWorkInUser> checkExistingAccount(AccountProperty accountProperty){
        try(FileInputStream fos=new FileInputStream(fileWithAccount)){

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }
    private void writeAccount(AccountProperty accountProperty){
        try(FileWriter fos=new FileWriter(fileWithAccount, true)){
            fos.write(accountProperty.getLogin());
            fos.write(" ");
            String pass=accountProperty.getPassword();
            fos.write(" ");
            fos.write(accountProperty.getEmail());
            fos.write(" ");
            fos.write(accountProperty.getAccountType().toString()+"\n");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public AccountProperty ReadUserInfo(FileReader fileReader){
        Scanner scanner =new Scanner(fileReader);
        String str=scanner.nextLine();
        if(scanner.hasNextLine()) {
            Pattern pattern = Pattern.compile(" ");
            String[] arrayStr = pattern.split(str);
            AccountProperty accountType = new AccountProperty(arrayStr[0],arrayStr[1]);
            accountType.setAccountType(AccountType.valueOf(arrayStr[3]));
            accountType.setEmail(arrayStr[2]);
            return accountType;
        }
        return null;
    }

    public BookWorkInUser enterUsers(){
        do{
            AccountProperty accountProperty=getUsersInfo();
            Optional<BookWorkInUser> optional=checkExistingAccount(accountProperty);
            if(!optional.isEmpty()){
                break;
            }
            System.out.println("Error, Invalid password or login! Try again...");

        }while(true);
        throw new UnsupportedOperationException();
    }
    public boolean registerUser(){
        AccountProperty accountProperty=getUsersInfo();
        System.out.print("Enter your email: ");
        Scanner scanner=new Scanner(System.in);
        String email = scanner.nextLine();
        accountProperty.setEmail(email);
        accountProperty.setAccountType(AccountType.User);
        writeAccount(accountProperty);
        return true;
    }

}
