package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {
    @Test
    public void testBottle(){
        Bottle bottle= Bottle.of(BottleType.GLASS_BOTTLE);
        assertEquals(50, bottle.getType().getMaximumAmount());

        bottle.fill(22);
        bottle.fill(11);
        assertEquals(33, bottle.getFilledUntil());

        assertThrows(IllegalArgumentException.class, () -> bottle.fill(18));

        bottle.fill(17);
        assertEquals(50, bottle.getFilledUntil());
    }


}