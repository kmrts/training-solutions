package week06d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    @Test
    public void testBudget(){
        List<Item> items= new ArrayList<>();
        items.add(new Item(200, 4, "valami"));
        items.add(new Item(300, 6, "másvalami"));
        items.add(new Item(100, 1, "egyéb akármi"));
        items.add(new Item(400, 4, "más"));
        Budget b= new Budget(items);

        assertEquals(100, items.get(2).getPrice());
        assertEquals("más", items.get(3).getName());

        assertEquals(400, b.getItemsByMonth(4).get(1).getPrice());

        assertThrows(IllegalArgumentException.class, () -> b.getItemsByMonth(0));
        assertThrows(IllegalArgumentException.class, () -> b.getItemsByMonth(21));
    }

    @Test
    public void testBudgetNull(){

        assertThrows(NullPointerException.class, () -> new Budget(null));


    }

}