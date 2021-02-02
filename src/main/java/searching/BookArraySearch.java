package searching;

import java.util.Arrays;

public class BookArraySearch {
    /*
    Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek között tud keresni adott szerzőre és címre.
    Az osztályban a könyveket objektum tömb formájában tároljuk, a keresés legyen bináris keresés.

BookArraySearch osztály private Book[] bookArray attribútummal. Ezt konstruktorból tudjuk feltölteni.

publikus metódusok:

 public BookArraySearch(Book[] bookArray)
 public Book findBookByAuthorTitle(String author, String title)

Kivételkezelés

A két String paramétert le kell ellenőrizni, üres String esetén dobjon IllegalArgumentException-t.
Ha a bináris keresés nem talál könyvet, dobjon IllegalArgumentException-t a megfelelő tájékoztató szöveggel.
     */
    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title){
        if(isEmpty(author) || isEmpty(title)){
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
//        if(author==null || title==null|| author.isEmpty() || title.isEmpty()){
//            throw new IllegalArgumentException("Author or title must not be empty!");
//        }
        Arrays.sort(bookArray);
        try {
            int index = Arrays.binarySearch(bookArray, new Book(1, author, title));
            return bookArray[index];
        }catch (IndexOutOfBoundsException ex){
            throw new IllegalArgumentException("No book found by " + author + " with title " + title, ex);
        }
    }
    private boolean isEmpty(String param){
        return param==null || param.isEmpty();
    }
}
