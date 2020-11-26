package week05d04;

import org.junit.jupiter.api.Test;

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
    public void testAdd(){
        Store st2= new Store(Arrays.asList(new Product("pad", 2020, 12, 20)) );


        st2.addProduct(new Product("deszka", 2021, 01,20));
        System.out.println(st2.getProducts().get(2).getDate());

//        assertEquals("2021-01-20", st.getProducts().get(2).getDate());

    }


}
