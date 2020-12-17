package week08d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {
    @Test
    public void testStringLists(){
        StringLists sl= new StringLists();
        List<String> list1= new ArrayList<>(Arrays.asList("egy", "két", "négy", "öt"));
        List<String> list2= new ArrayList<>(Arrays.asList("egy", "hár", "öt", "hat", "hét"));
//        System.out.println(sl.stringListsUnion(list1, list2));  --> [egy, két, négy, öt, hár, hat, hét]

        assertEquals("[egy, két, négy, öt, hár, hat, hét]", sl.stringListsUnion(list1, list2).toString() );
    }

}