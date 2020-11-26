package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    //Készíts egy week05d04.Store osztályt, melyben van egy Productokat tároló lista.
    // Legyen benne egy addProduct(Product) metódus.
    //Bónusz: Legyen benne egy getNumberOfExpired() metódus ami visszaadja a lejárt termékek számát.
    // Használd a LocalDate.now() és az isBefore() metódusokat.
    //Tesztelj!
    private List<Product> products= new ArrayList<>();

//    public Store() {
//
//    }
    public Store(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product productToAdd){
        products.add(productToAdd);
    }
    public int getNumberOfExpired(){
        int count=0;
        for(Product pItem: products){
            if(pItem.getDate().isBefore(LocalDate.now())){
                count++;
            }
        }
        return count;
    }

}
