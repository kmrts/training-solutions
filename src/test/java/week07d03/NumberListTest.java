package week07d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberListTest {

    @Test
    public void testNumberList(){

        List<Integer> list1= Arrays.asList(1, 2, 2, 4, 55);
        List<Integer> list2= Arrays.asList(1, 2, 2, 4, 3, 3);
        List<Integer> list3= Arrays.asList(1, 2, 2, 4, 8, 6);

        assertEquals(true, NumberList.isIncreasing(list1) );
        assertEquals(false, NumberList.isIncreasing(list2) );

        assertTrue(NumberList.isIncreasing(list1));
        assertFalse(NumberList.isIncreasing(list2));

    }


}