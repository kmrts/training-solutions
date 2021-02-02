package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    /*
    Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek szoftveres menedzselését valósítja meg.
    A könyvtárat feltöltjük egyedi könyvekkel, és egyedi regisztrációs szám alapján kikereshetjük, eltávolíthatjuk a könyvtár állományából,
    illetve szerző szerint kigyűjthetünk könyveket.

    LibraryManager osztály Set<Book> libraryBooks attribútummal. Ezt konstruktorból tudjuk feltölteni.

publikus metódusok:

 public Book findBookByRegNumber(int regNumber)
 public int removeBookByRegNumber(int regNumber)
 public Set<Book> selectBooksByAuthor(String author)
Mindhárom metódus saját MissingBookException-t (RuntimeException) dob, ha a regisztrációs számnak megfelelő könyv nem található,
vagy adott szerzővel nem található könyv.

Tipp
Használjunk iterátoros bejárást a könyvek megtalálására és kigyűjtésére.
A tesztelés segítésére készítsünk egy public int libraryBooksCount() metódust is, ami visszaadja a Book kollekció méretét.
     */
    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber){

        Iterator<Book> iterator= libraryBooks.iterator();
        while(iterator.hasNext()){
            Book b= iterator.next();
            if(b.getRegNumber()== regNumber){  //b.getRegNumber()== regNumber
                return b;
            }
        }
        throw new MissingBookException("No books found with regnumber: ", regNumber);

    }
    public int removeBookByRegNumber(int regNumber){
        Iterator<Book> iter= libraryBooks.iterator();
        while( iter.hasNext()){
            Book b= iter.next();
            if(b.getRegNumber()== regNumber){
                iter.remove();   ///
                return regNumber;
            }
        }
//        for(Iterator<Book> i= libraryBooks.iterator(); i.hasNext(); ) {
//            if( i.next().getRegNumber()== regNumber){
//                libraryBooks.remove();
//            }
//        }

        throw new MissingBookException("No books found with regnumber: ", regNumber);
    }
    public Set<Book> selectBooksByAuthor(String author){
        Set<Book> bookSet= new HashSet<>();
        Iterator<Book> it= libraryBooks.iterator();
        while ( it.hasNext()){
            Book b= it.next();
            if(b.getAuthor().equals( author )){
                bookSet.add(b);
            }
        }
        if(bookSet.isEmpty()){
            throw new MissingBookException("No books found by ", author);
        }
        return bookSet;
    }

    public int libraryBooksCount(){
        return libraryBooks.size();
    }
}
