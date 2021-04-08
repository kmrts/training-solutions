package week06d01.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    public void testSum(){
        SeparatedSum sep= new SeparatedSum();
        String st= "15,36;-255,4;233,5;-2,2";

        assertEquals(-257.6, sep.sum(st).getNeg());
        assertEquals(248.86, sep.sum(st).getPos());

    }

}