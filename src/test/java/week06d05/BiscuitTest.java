package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiscuitTest {

    @Test
    public void testBiscuit() {
        Biscuit b1= Biscuit.of(BiscuitType.CORPOVIT, 150);  //
        assertEquals(150, b1.getGramAmount());
        assertEquals("type= CORPOVIT, gramAmount= 150", b1.toString());

    }

}