package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void testFindDivisors() {
        DivisorFinder df= new DivisorFinder();

        assertEquals(1, df.findDivisors(425));
        assertEquals(2, df.findDivisors(210));
        assertEquals(0, df.findDivisors(0));
        assertEquals(4, df.findDivisors(54312));

    }
}