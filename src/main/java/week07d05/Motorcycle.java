package week07d05;

public class Motorcycle extends Vehicle{

    public Motorcycle(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }

    public Motorcycle() {

        setTransmissionType(TransmissionType.SEQUENTIAL);
    }
}
