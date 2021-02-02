package collectionscomp;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OrderedLibrary {
    /*
    Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek szoftveres menedzselését valósítja meg.
    A könyvtárat feltöltjük könyvekkel, és kereséshez cím vagy szerő szerint rendezhetjük a könyveket.
    Alapértelmezett a cím szerinti rendezés.
    Egy külön metódusban valósítsuk meg a könyvcímek magyar ékezetes karaktereket is figyelembe vevő rendezését.
    Csak a könyvcímek kellenek, nem a könyvek!

OrderedLibrary osztály List<Book> libraryBooks attribútummal. Ezt konstruktorból tudjuk feltölteni.

publikus metódusok:

 public OrderedLibrary(List<Book> libraryBooks)
 public List<Book> orderedByTitle()
 public List<Book> orderedByAuthor()
 public List<String> orderedByTitleLocale(Locale locale)

Egy külön osztályban (AuthorComparator) valósítsuk meg a szerző szerint történő rendezéshez szükséges Comparator osztályt.

[rating feedback=java-collectionscomp-orderedlibrary]
Bónusz feladat - Collator

Az ékezetes karaktereket is figyelembe vevő String rendezéshez a Collator osztály egy példányára lesz szükségünk.
Nézz utána, ez hogyan állítható elő és hogyan paraméterezhető!
Bónusz feladat - Comparator

A Comparator objektumot többnyire névtelen osztály példányaként állítjuk elő. Nézz utána, ez hogyan valósítható meg!
     */
    private List<Book> libraryBooks= new ArrayList<>();

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }
    public List<Book> orderedByTitle(){
        List<Book> orderedList= new ArrayList<>(libraryBooks);
        Collections.sort(orderedList);
        return orderedList;
    }
    public List<Book> orderedByAuthor(){
        List<Book> orderedList= new ArrayList<>(libraryBooks);
        Collections.sort(orderedList, new AuthorComparator());
        return orderedList;
    }
    public List<String> orderedByTitleLocale(Locale locale){
        List<String> titleList= new ArrayList<>();
        for(Book b: libraryBooks){
            titleList.add(b.getTitle());
        }
        Collections.sort(titleList, Collator.getInstance(locale));
        return titleList;
    }

}
