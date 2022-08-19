package application.books;

import java.io.FileOutputStream;

public class BookPrint {

    private FileOutputStream outputFile;

    public BookPrint(FileOutputStream outputFile) {
        this.outputFile = outputFile;
    }

    public void writeBook(){
        throw new UnsupportedOperationException();
    }
}
