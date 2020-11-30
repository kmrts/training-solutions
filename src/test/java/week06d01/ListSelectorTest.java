package week06d01;

import org.junit.jupiter.api.Test;
import week05d05.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListSelectorTest {

    @Test
    public void testListSelector() {

        List<String> list = Arrays.asList("Álmos", "Előd", "Ond", "Kond", "Tas", "Huba", "Töhötöm", "Qka");
        ListSelector ls = new ListSelector();
        assertEquals("[Álmos,Ond,Tas,Töhötöm]", ls.listSel(list));
    }

    @Test
    public void testIfNull() {
        List<String> list = null;
        ListSelector ls = new ListSelector();

        assertThrows(IllegalArgumentException.class, () ->
                {
                    ls.listSel(list);
                }
        );
    }
    @Test
    public void testEmptyList() {

        List<String> list = new ArrayList<>();
        ListSelector ls = new ListSelector();
        assertEquals("", ls.listSel(list));
    }

}