package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {
    /*
     A könyvtárban a könyveket tömb segítségével tároljuk, ezt kell rendezni igény esetén különböző szempontok alapján.

OrderedArrayLibrary osztály private Book[] bookArray attribútummal. Ezt konstruktorból tudjuk feltölteni.
publikus metódusok:
 public OrderedArrayLibrary(Book[] bookArray)
 public Book[] sortingById()
 public Book[] sortingByTitle()

A rendezés során az eredeti tömb egy másolatát adjuk vissza, a megfelelő szempont szerint rendezve!
Tipp

A rendezéshez szükséges Comparator objektumot előállíthatjuk külön osztályból, vagy névtelen osztályból is.
     */
    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }
    public Book[] sortingById(){
        Book[] sortedBooks= bookArray;
        Arrays.sort(sortedBooks);
        return sortedBooks;
    }
    public Book[] sortingByTitle(){
        Book[] sortedBooks= bookArray;
        Arrays.sort(sortedBooks, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return sortedBooks;
    }
}
