package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibCalculatorTest {
    @Test
    public void testFibCalc(){
        FibCalculator fibc= new FibCalculator();

        assertEquals(2, fibc.sumEvens(2));
        assertEquals(0, fibc.sumEvens(1));
        assertEquals(0, fibc.sumEvens(-10));

        assertEquals(10, fibc.sumEvens(11));
        assertEquals(44, fibc.sumEvens(40));
        assertEquals(188, fibc.sumEvens(151));
        assertEquals(60696, fibc.sumEvens(190000));
    }

    @Test
    public void testTillThous(){
        FibCalculator f= new FibCalculator();

        assertEquals(1_089_154, f.sumEvensTillThous());
    }

}