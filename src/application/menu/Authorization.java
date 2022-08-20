package application.menu;

import application.account.*;
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
            Scanner scanner=new Scanner(fos);
            while(scanner.hasNextLine()){
                String str=scanner.nextLine();
                Pattern pattern = Pattern.compile(" ");
                String[] arrayStr = pattern.split(str);
                AccountProperty account = new AccountProperty(arrayStr[0],arrayStr[1]);
                account.setAccountType(AccountType.valueOf(arrayStr[3]));
                account.setEmail(arrayStr[2]);
                if(accountProperty.equals(account)){
                    BookWorkInUser bookWorkInUser=null;
                    if(account.getAccountType()==AccountType.Admin){
                        bookWorkInUser=new Admin();
                    }
                    else{
                        bookWorkInUser=new User();
                    }
                    return Optional.of(bookWorkInUser);
                }
            }
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

    public BookWorkInUser enterUsers() throws IllegalStateException{

            AccountProperty accountProperty=getUsersInfo();
            Optional<BookWorkInUser> optional=checkExistingAccount(accountProperty);
            if(optional.isEmpty()){
                throw new IllegalStateException();
            }
            else return optional.get();
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
