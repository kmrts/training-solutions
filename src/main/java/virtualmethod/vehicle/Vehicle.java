package virtualmethod.vehicle;

public class Vehicle {
    //Hozz létre egy Vehicle osztályt. Az általános jármű osztálynak van önsúlya, és legalább egy vezető.
    // Ezek adják a teljes súlyát.
    //
    //    Vezess be egy vehicleWeight privát attribútumot, a jármű súlya.
    //    PERSON_AVERAGE_WEIGHT konstans érték: egy személy átlagos súlyát tartalmazza. Az értéke legyen 75.
    //    Hozz létre egy konstruktort, amely megkap egy értéket az attribútum számára, és beállítja azt.
    //    Szükséges metódus a getGrossLoad, amely visszaadja a mozgó jármű súlyát. (A jármű súlyához adjuk hozzá a sofőr súlyát.)
    //

    private int vehicleWeight;
    static final int PERSON_AVERAGE_WEIGHT =75;

    public Vehicle(int vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }
    public int getGrossLoad(){
        return vehicleWeight+ PERSON_AVERAGE_WEIGHT;
    }

    public int getVehicleWeight() {
        return vehicleWeight;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleWeight=" + vehicleWeight +
                '}';
    }
}

