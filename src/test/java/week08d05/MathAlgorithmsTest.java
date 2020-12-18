package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    public void testMathAlg(){
        MathAlgorithms ma= new MathAlgorithms();

        assertEquals(4, ma.greatestCommonDivisor(28, 400 ));
        assertEquals(20, ma.greatestCommonDivisor(20, 800 ));
        assertEquals(1, ma.greatestCommonDivisor(1, 2 ));
        assertEquals(1051, ma.greatestCommonDivisor(1051, 1051 ));
    }

}