package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {
    /*
    a könyv címét és szerzőjét tartalmazza. A Library osztály a könyvek listáját attribútumként tárolja.
    Könyveket lehet hozzáadni az add(Book...) metódusával, mely csak azokat a könyveket adja a listához,
    amelyek még nem voltak benne.
    Az osztály aktuális állapotát szöveges fájlba lehet menteni, illetve fájlból be lehet tölteni az ott lévő könyveket.

    + UML ábra
     */
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }

    public void add(Book book) {
        boolean exists= false;
        for (Book b : bookList) {
            if (book.getAuthor() == b.getAuthor() && book.getTitle() == b.getTitle()) {   //equals
                exists = true;
                System.out.println("The library already contains this book!");
                break;
            }
        }
        if(!exists){
            bookList.add(book);
        }

    }

    public void saveLibrary(Path targetPath) {
        try (BufferedWriter buw = Files.newBufferedWriter(targetPath)) {
            for (Book book : bookList) {
                String item = book.getAuthor() + ": " + book.getTitle();
                buw.write(item + "\n");
            }
        } catch (IOException exc) {
            throw new IllegalStateException("can not write file", exc);
        }
    }

    public void loadBooks(Path sourcePath) {
        try (BufferedReader bur = Files.newBufferedReader(sourcePath)) {

                String line;
                while ((line = bur.readLine()) != null) {
                    String splitted[] = line.split(": ");
                    bookList.add(new Book(splitted[0], splitted[1]));
                }
        } catch (IOException exc) {
            throw new IllegalStateException("can not read file", exc);
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.add(new Book("Szerző", "Cím"));
        lib.add(new Book("Bodó Béla", "Brumi mindenhol"));
        System.out.println(lib.getBookList().get(1).getAuthor() +": "+ lib.getBookList().get(1).getTitle());

//        lib.saveLibrary(Path.of("booksave.txt"));

        lib.loadBooks(Path.of("books_up.txt"));
        System.out.println(lib.getBookList().size());

        lib.saveLibrary(Path.of("booksave.txt"));
    }
}
