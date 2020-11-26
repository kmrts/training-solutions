package week05d04;

import java.util.ArrayList;
import java.util.List;

public class Store {
    //Készíts egy week05d04.Store osztályt, melyben van egy Productokat tároló lista. Legyen benne egy addProduct(Product) metódus.
    //Bónusz: Legyen benne egy getNumberOfExpired() metódus ami visszaadja a lejárt termékek számát. Használd a LocalDate.now() és az isBefore() metódusokat.
    //Tesztelj!
    private List<Product> products= new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product productToAdd){
        products.add(productToAdd);
    }
}
