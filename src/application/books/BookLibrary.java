package application.books;

import java.util.ArrayList;
import java.util.HashMap;

public class BookLibrary {
    private HashMap<String,Book> catalog=new HashMap<>();

    public final HashMap<String,Book> getCatalogMap(){return catalog;}
    public ArrayList<Book> getCatalog(){
        if(catalog.size()==0)
            return null;
        return new ArrayList<>(catalog.values());
    }

    public Book getBook(String keyName){
        if(catalog.containsKey(keyName)){

            return catalog.get(keyName);
        }
        return null;
    }

    public boolean removeBookFromCatalog(String keyName){
        if(catalog.containsKey(keyName)){
            catalog.remove(keyName);
            return true;
        }
        return false;
    }
    @Deprecated
    public void addBook(Book book){
        catalog.put(book.getName(),book);
    }
}
