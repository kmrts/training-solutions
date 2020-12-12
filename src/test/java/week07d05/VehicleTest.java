package week07d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void testVehicle(){
        assertEquals(5, new Vehicle().getNumberOfGears());
        assertEquals(4, new Vehicle(4, TransmissionType.AUTOMATIC).getNumberOfGears());

    }
    @Test
    public void testCar(){
        assertEquals(4, new Car(4).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Car(4).getTransmissionType());

    }
    @Test
    public void testMotorcycle(){
        assertEquals(5, new Motorcycle().getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, new Motorcycle().getTransmissionType());

    }

}