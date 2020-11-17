package filescanner.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> booklist= new ArrayList<>();///

    public void loadFromFile(){
        try(Scanner sca= new Scanner(Library.class.getResourceAsStream("/books.csv"))){  //main/resources-ba
            sca.useDelimiter(";|(\r\n)|\n");  //
            while(sca.hasNextLine()){
//                System.out.println(sca.nextLine());
                String regNum= sca.next();
                String author= sca.next();
                String title= sca.next();
                int yearOfPublish= sca.nextInt();
                booklist.add(new Book(regNum, author, title, yearOfPublish));  ////
            }

        }  // nem kell catch, lezárja

    }
    public List<Book> getBooks(){  ///
        return booklist;
    }

    public static void main(String[] args) {
        Library l = new Library();
        l.loadFromFile();
        System.out.println(l.getBooks().toString());
    }
}
