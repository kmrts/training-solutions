package week07d05;

public class Car extends Vehicle {

//    public Car() {
//        transmissionType= TransmissionType.AUTOMATIC;
//
//    }

    public Car(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }

    public Car(int numberOfGears) {
        setNumberOfGears(numberOfGears);
        setTransmissionType(TransmissionType.AUTOMATIC);
    }


}
