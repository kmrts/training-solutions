package week06d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void testProduct(){

        Product p= new Product("milk", Category.DAIRY, 200);

        assertEquals(200, p.getPrice());
        assertEquals(Category.DAIRY, p.getCategory());
    }

}