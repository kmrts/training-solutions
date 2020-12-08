package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumTest {

    @Test
    public void testDigit(){
        DigitSum ds= new DigitSum();
        assertEquals(25, ds.sumOfDigits(15667));
        assertEquals(0, ds.sumOfDigits(0));
        assertEquals(-11, ds.sumOfDigits(-74));
        assertEquals(7, ds.sumOfDigits(7));
        assertEquals(20, ds.sumOfDigits(712334));
    }

}