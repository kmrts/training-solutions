package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {
    /*
    A Book osztály objektumait rakjuk bele List és Set kollekció típusokba.
    Vizsgáljuk meg, hogy mely tesztesetek futnak le sikeresen, és melyek nem a Book osztályban felülírt,
    vagy éppen kihagyott equals és hashCode metódusok esetén. Értelmezzük a tapasztaltakat!

A BookCatalog osztályban a következő publikus metódusok találhatók (ezek persze a tesztesetekből is következnek):

public Book findBookByTitleAuthor(List<Book> books, String title, String author)
public Book findBook(List<Book> books, Book book)
public Set<Book> addBooksToSet(Book[] books)
Hibakezelés
Használjuk ki a kollekciók boolean contains(Object o) metódusát!
Ha a metódus nem találja a keresett objektumot, a visszatérési érték legyen null.

Megvalósítás
A Book osztályban az equals(Object o) és hashCode() metódusok megírásával és kikommentelésével (összes kombináció!)
próbáljuk ki az egyes tesztesetek sikeres vagy sikertelen lefutását. Értelmezzük a tapasztaltakat!
     */
    public Book findBookByTitleAuthor(List<Book> books, String title, String author){
        for(Book b: books){
            if(b.getTitle().equals(title) && b.getAuthor().equals(author)){
                return b;
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book book){
        for(Book b: books){
            if(b.equals(book)){
                return b;
            }
        }
        return null;
    }
    public Set<Book> addBooksToSet(Book[] books){
        Set<Book> bookSet= new HashSet<>();

        for(Book b: books){
            if(!bookSet.contains(b)){
                bookSet.add(b);
            }
        }
        return bookSet;

    }

}
