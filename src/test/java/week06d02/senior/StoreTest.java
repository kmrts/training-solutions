package week06d02.senior;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void getProductsByCategory() {
        List<Product> products= new ArrayList<>();
        products.add(new Product("Keefley", Category.BAKEDGOODS, 200));
        products.add(new Product("Pot", Category.OTHER, 150));
        products.add(new Product("Yogurt", Category.DAIRY, 410));
        products.add(new Product("Roll", Category.BAKEDGOODS, 240));
        Store store= new Store(products);

//        System.out.println(store.getProductList());
        System.out.println(store.getProductsByCategory());

        assertEquals(2, store.getProductsByCategory().get(Category.BAKEDGOODS));
    }
}