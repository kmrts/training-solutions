package week05d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    Store st= new Store(Arrays.asList(new Product("pad", 2020, 12, 20),
            new Product("asztal", 2020, 11, 10)) );

    @Test
    public void testStore(){

        assertEquals("asztal", st.getProducts().get(1).getName());

    }
    @Test
    public void testAddandExpired(){
        //Tömbökből is készíthetünk listát az Arrays.asList() metódussal azzal a megkötéssel,
        // hogy elemeket utólagosan sem hozzáadni, sem törölni nem tudunk.

        List<Product> p1= new ArrayList<>();
        p1.add(new Product("pad", 2020, 12, 20));
        Store s= new Store(p1);

        Product p= new Product("másvalami", 2020, 10, 9);
        s.addProduct(p);

        assertEquals(10, s.getProducts().get(1).getDate().getMonthValue());

        assertEquals(1, s.getNumberOfExpired());
        s.addProduct(new Product("harmadik", 2020, 11, 25));
        assertEquals(2, s.getNumberOfExpired());
    }


}
