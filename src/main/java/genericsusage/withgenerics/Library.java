package genericsusage.withgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List<Book> bookList){
        if(bookList== null){
            throw new NullPointerException("it is null");
        }
        if(bookList.isEmpty()){
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        return bookList.get(0);
    }
}
