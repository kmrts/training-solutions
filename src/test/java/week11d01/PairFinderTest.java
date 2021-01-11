package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testFindPairs() {

        PairFinder pf= new PairFinder();

        assertEquals(1, pf.findPairs(new int[]{5, 1, 4, 5}));
        assertEquals(3, pf.findPairs(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));
        assertEquals(3, pf.findPairs(new int[]{-1, 22, 365, 22, 1, -1, -1, 21, 1555, 5, 5}));

        assertEquals(0, pf.findPairs(new int[]{}));
        assertThrows(IllegalArgumentException.class, ()-> pf.findPairs(null) );
    }
}