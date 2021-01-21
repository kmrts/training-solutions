package week12d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test
    void testOnlyOne(){
        NumberStat ns= new NumberStat();
        List<Integer> numlist= new ArrayList<>(List.of(2, 3));
        List<Integer> numlist2= Arrays.asList(1,1,5,3,4,5,6,5,6,4,1,6,5,4);

        assertEquals(2, ns.onlyOneTime(numlist));
        assertEquals(3, ns.onlyOneTime(numlist2));
    }

}