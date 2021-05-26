package week07d04.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    public void calculateSumTest(){
        ShoppingList shl= new ShoppingList();

        assertEquals(2301, shl.calculateSum("bevlist.txt"));
    }

}