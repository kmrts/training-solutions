package controladvanced.duplicates;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatesTest {

    @Test
    public void DuplTest(){

        assertEquals(Arrays.asList(), new Duplicates().findDuplicates(Arrays.asList()));   ////
        assertEquals(Arrays.asList(), new Duplicates().findDuplicates(Arrays.asList(1,3,5)));
        assertEquals(Arrays.asList(3), new Duplicates().findDuplicates(Arrays.asList(1,3,5,3)));
        assertEquals(Arrays.asList(1,8,3), new Duplicates().findDuplicates(Arrays.asList(1,1,3,5,8,8,3)));
    }
}
