package week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void testGetMaxIndex() {
        MaxTravel mt= new MaxTravel();
        List<Integer> list= List.of(12,12,0,3,4,4);
        List<Integer> list2= List.of(15);
        List<Integer> list3= List.of(21,2,10,5,10,2,2,25,11,10,2,10);

        assertEquals(4, mt.getMaxIndex(list));
        assertEquals(15, mt.getMaxIndex(list2));
        assertEquals(2, mt.getMaxIndex(list3));

        assertEquals("[15]", mt.getMaxIndexList(list2).toString());

        assertEquals(4, mt.getMaxIndexList(list).get(0));
        assertEquals(12, mt.getMaxIndexList(list).get(1));
        assertEquals(10, mt.getMaxIndexList(list3).get(1));


    }
}