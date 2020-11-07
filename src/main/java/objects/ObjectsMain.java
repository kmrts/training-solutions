package objects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ObjectsMain {

    public static void main(String[] args) {
        new Book();
        System.out.println(new Book()); //objects.Book@7699a589

        Book emptyBook;
//        System.out.println(emptyBook); //might not have been initialized

        emptyBook= null;
        System.out.println(emptyBook); // null

        Book book= new Book();
        System.out.println(book); //objects.Book@58372a00

        book= null;
        System.out.println(book); //null

        book= new Book();
        System.out.println(book); //objects.Book@4dd8dc3

        Book anotherBook = new Book();
        System.out.println(book == anotherBook); //false

        anotherBook= book;
        System.out.println(anotherBook); //objects.Book@4dd8dc3
        System.out.println(book == anotherBook); //true

        System.out.println(anotherBook instanceof Book); //true

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book5;
        book5 = new Book();
        book6 = null;

        //5 obj, 3-hoz férh hozzá (1,2,5)

        Book[] books= {book1, book2, book5};
        List<Book> boker= Arrays.asList(book5, book2, book1);
        List<Book> boker2= new ArrayList<>();
        boker2.add(book2);
        boker2.add(book5);
        boker2.add(book1);

//        System.out.println(books); // [Lobjects.Book;@6d03e736

    }
}
