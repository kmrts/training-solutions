package week06d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testAddAndGetItem() {
        ShoppingCart sc= new ShoppingCart();
        sc.addItem("bread", 1);
        sc.addItem("mineral w", 4);
        sc.addItem("cheese", 3);
        sc.addItem("apple", 5);
        sc.addItem("cheese", 4);

        assertEquals(4, sc.getItemList().size());
        assertEquals("apple", sc.getItemList().get(3).getName());

        assertEquals(7, sc.getItem("cheese"));
    }

}