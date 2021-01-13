package week11d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    public void testAddRide(){
        Courier c= new Courier();
        c.addRide(new Ride(1, 1, 12));
        c.addRide(new Ride(1, 2, 11));
        c.addRide(new Ride(2, 1, 10));

        assertEquals(11, c.getRides().get(1).getWay());
        assertThrows(IllegalArgumentException.class, ()-> c.addRide(new Ride(1, 3, 10) ));
        assertThrows(IllegalArgumentException.class, ()-> c.addRide(new Ride(2, 1, 10) ));
        //1 2 11 2 1 10 4 1 19

    }
    @Test
    public void testNoRide(){
        Courier c= new Courier();
        c.addRide(new Ride(1, 1, 12));
        c.addRide(new Ride(1, 2, 11));
        c.addRide(new Ride(2, 1, 10));
        c.addRide(new Ride(4, 1, 19));
        assertEquals(3, c.earlierDayNoRides());

        Courier c2= new Courier();
        c2.addRide(new Ride(1, 1, 12));

        assertThrows(IllegalArgumentException.class, ()-> c2.earlierDayNoRides());

    }

}