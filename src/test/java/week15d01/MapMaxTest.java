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

        System.out.println(mm.maxOfMap(aMap));
    }

}