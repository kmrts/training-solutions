package week05d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProduct(){

        Product p= new Product("léc", 2025, 10, 10);
//        System.out.println(p.getDate());

        assertEquals("2025-10-10", p.getDate().toString()) ; //kell a toString()

    }
}
