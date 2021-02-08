package collectionsiterator;

import java.util.Objects;

public class Book {
    /*


Megvalósítás
Book osztály int regNumber String title és String author attribútumokkal.

Az equals() és hashCode() metódusokat az igényeknek megfelelően készítsük el, egyedi a regNumber attribútum.

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return regNumber == book.regNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }
}
