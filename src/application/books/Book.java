package application.books;

public class Book {
    private BookType bookType;
    private String name;
    private String author;
    private int year;

    public Book(BookType type, String name, String author,int year ){
        this.bookType=type;
        this.name=name;
        this.author=author;
        this.year=year;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
