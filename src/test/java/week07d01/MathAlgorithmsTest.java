package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    public void testPrim(){
        MathAlgorithms m= new MathAlgorithms();

        assertEquals(true, m.isPrime(17));
        assertEquals(true, m.isPrime(2));
        assertEquals(false, m.isPrime(222));
        assertEquals(true, m.isPrime(19));
        assertEquals(false, m.isPrime(111));
        assertEquals(true, m.isPrime(1511));

        assertThrows(IllegalArgumentException.class, () -> m.isPrime(0) );
    }

}