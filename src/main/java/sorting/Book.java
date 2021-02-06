package sorting;

import java.util.Objects;

public class Book implements Comparable<Book>{
    /*
    Book osztály int id String title és String author attribútumokkal.

A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.
Alapértelmezett az id szerinti rendezés.
     */
    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author.trim();
        this.title = title.trim();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id; //Objects.hash(id)
    }
}
