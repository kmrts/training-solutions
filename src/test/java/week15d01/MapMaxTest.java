package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapMaxTest {
    @Test
    void testMaxOfMap(){
        MapMax mm= new MapMax();
        Map<Integer, Integer> aMap= new HashMap<>();
        aMap.put(0, 2);
        aMap.put(1, 1);
        aMap.put(2, 3);
        aMap.put(3, 1);
        aMap.put(4, 3);
        Map<Integer, Integer> bMap= Map.of(2,3, 3,4,5,-1, -1,2);

        System.out.println(mm.maxOfMap(aMap));
        assertEquals(2, mm.maxOfMap(aMap).getKey() );
        assertEquals(3, mm.maxOfMap(aMap).getValue() );

        assertEquals(3, mm.maxOfMap(bMap).getKey() );
        assertEquals(4, mm.maxOfMap(bMap).getValue() );
    }

}