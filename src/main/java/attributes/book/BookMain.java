package attributes.book;

public class BookMain {
    public static void main(String[] args) {

        Book b= new Book("Ez a könyv címe");
        System.out.println(b.getTitle());

        b.setTitle("Ez az új címe");
        System.out.println(b.getTitle());
    }
}
