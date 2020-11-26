package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {
    List<String> list1= Arrays.asList("ananas", "banana", "lemon", "apple");
    List<String> list2= Arrays.asList("Asia", "Europe", "Australia", "america", "Afrika");
//    new List<String> list2= {"banán", "alma"};

    @Test
    public void testListCounter(){
        assertEquals(2, new ListCounter().startsWhithA(list1));
        assertEquals(4, new ListCounter().startsWhithA(list2));
    }
}
