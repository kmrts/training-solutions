package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    public void testStore(){

        List<Product> productList= new ArrayList<>();
        productList.add(new Product("milk", Category.DAIRY, 200));
        productList.add(new Product("fish", Category.FROZEN, 400));
        productList.add(new Product("bread", Category.BAKEDGOODS, 300));
        productList.add(new Product("cranberries", Category.FROZEN, 500));

        Store s1= new Store(productList);
        assertEquals(2, s1.getProductByCategoryName(Category.FROZEN));
    }

}