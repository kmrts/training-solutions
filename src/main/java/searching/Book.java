package searching;

import java.util.Objects;

public class Book implements Comparable<Book> {
    /*
    Book osztály int id String title és String author attribútumokkal.

A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.
Alapértelmezetten szerző és ezen belül cím alapján rendezi a Book objektumokat.
     */
    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return author.equals(book.author) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);  //szerző, azon belül cím
    }

    @Override
    public int compareTo(Book o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}
