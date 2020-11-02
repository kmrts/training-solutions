package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {

        Book book= new Book("Ken Folett", "Pillars on Earth");
        book.register("12568");

        System.out.println("Szerző: "+ book.getAuthor());
        System.out.println("Cím: "+ book.getTitle());
        System.out.println("Reg. sz: "+ book.getRegNumber());
    }
}
