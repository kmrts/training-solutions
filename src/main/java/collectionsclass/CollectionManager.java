package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {
    /*
    a Collections osztály kiválasztott metódusai segítségével "könyvtári szolgáltatásokat" nyújt.

CollectionManager osztály private List<Book> library attribútummal. Ezt konstruktorból tudjuk feltölteni.

publikus metódusok:

public CollectionManager(List<Book> library)
public List<Book> createUnmodifiableLibrary() //módosíthatatlan listát eredményez
public List<Book> reverseLibrary() //az eredeti lista másolatán dolgozik!
public Book getFirstBook() //a legrégebbi (legkisebb id) könyvet adja vissza
public Book getLastBook() // a legújabb (legnagyobb id) könyvet adja vissza
     */
    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }
    public List<Book> createUnmodifiableLibrary(){
//        return new ArrayList<>( Collections.unmodifiableList(library) );  //ez módosítható
        List<Book> listUnMod= Collections.unmodifiableList(library);
        return listUnMod;
    }
    public List<Book> reverseLibrary(){
//        List<Book> revList= Collections.reverse(library);  //nem ok

//        List<Book> revList=  library;
        List<Book> revList= new ArrayList<>(library);
        Collections.reverse(revList);

        return revList;

    }
    public Book getFirstBook(){
        return Collections.min(library);
    }
    public Book getLastBook(){
        return Collections.max(library);
    }
}
