package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store1= new Store("coffee");
        Store store2= new Store("cocoa");

        System.out.println("Nyitó: " +store1.getStock());
        store1.store(200);
        System.out.println(store1.getStock());
        store1.dispatch(100);
        System.out.println(store1.getStock());

        System.out.println("Nyitó: " +store2.getStock());
        store2.store(350);
        System.out.println(store2.getStock());
        store2.dispatch(125);
        System.out.println(store2.getStock());

    }
}
