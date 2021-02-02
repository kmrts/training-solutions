package collectionscomp;

public class Book implements Comparable<Book>{
    /*
    Book osztály int regNumber String title és String author attribútumokkal.
A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.
     */
    private int regNumber;
    private String title;
    private String author;

    public Book(int regNumber, String title, String author) {
        this.regNumber = regNumber;
        this.title = title;
        this.author = author;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book other) {
        return title.compareTo(other.title);
    }
}
