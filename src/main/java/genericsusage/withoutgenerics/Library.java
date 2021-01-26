package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    /*
    Implementálj egy könytárat, ahol könyveket tárolhatunk.
    Valósítsuk meg a getFirstBook() metódust generics használata nélkül, és generics használatával is.
Hibakezelés

    Ha a könyvtárat reprezentáló kollekció null, dobjon NullPointerException kivételt
    Ha a könyvtárat reprezentáló kollekció üres, dobjon IllegalArgumentException kivételt
     */
//    private List bookList= new ArrayList();
//
//    public List getBookList() {
//        return new ArrayList(bookList);
//    }

    public Book getFirstBook(List bookList){
        if(bookList== null){
            throw new NullPointerException("it is null");
        }
        if(bookList.isEmpty()){
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        try{
            return (Book)bookList.get(0); //v. if.. instanceof, throw
        }catch (ClassCastException cce){
            throw new ClassCastException("Not a book");
        }
    }
}
