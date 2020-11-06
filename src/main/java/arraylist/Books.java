package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    List<String> titles= new ArrayList<>();

    public List<String> getTitles() {
        return titles;
    }
    public void addTitle(String title){
        titles.add(title);

    }
//    public List<String> findAllByPrefix(String prefix){
//        ///még nem
//    }

    public static void main(String[] args) {

        Books books= new Books();
        books.addTitle("Első cím");
        books.addTitle("Második cím");
        books.addTitle("Még egy cím");
        System.out.println(books.getTitles());
    }
}
