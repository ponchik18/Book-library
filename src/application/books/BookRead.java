package application.books;

import java.io.FileInputStream;

public class BookRead {
    private FileInputStream outputFile;

    public BookRead(FileInputStream outputFile) {
        this.outputFile = outputFile;
    }

    public Book readBook(){
        throw new UnsupportedOperationException();
    }
}
