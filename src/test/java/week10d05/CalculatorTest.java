package week10d05;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testFindMinSum() {
        int[] arr1= {1, 3, 5, 7, 9};
        int[] arr2 = {13, 7, 6, 45, 21, 9, 1, 102, 20, 4};
        int[] arr3 = {14, 25, 6};

        assertEquals(16, new Calculator().findMinSum(arr1));
        assertEquals(18, new Calculator().findMinSum(arr2));

        assertThrows(IllegalArgumentException.class, () -> new Calculator().findMinSum(arr3));
    }
}