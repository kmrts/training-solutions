package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store1= new Store("coffee");
        Store store2= new Store("cocoa");

        System.out.println("Nyitó: " +store1.stock);
        store1.store(200);
        System.out.println(store1.stock);
        store1.dispatch(100);
        System.out.println(store1.stock);

        System.out.println("Nyitó: " +store2.stock);
        store2.store(350);
        System.out.println(store2.stock);
        store2.dispatch(125);
        System.out.println(store2.stock);

    }
}
