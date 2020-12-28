package virtualmethod.vehicle;

public class Car extends Vehicle {
    //Hozz létre egy Car osztályt, amely az általánosabb jármű osztályból származik (Vehicle) a következők alapján
    //
    //    tartalmaz egy attribútumot
    //    numberPassenger: egész szám, amely az utasok számát jelenti (sofőr nélkül)
    //    konstruktor, amely megkap két értéket az attribútumok számára, és beállítja azokat (az ős attribútumát a super hívással).
    //    getGrossLoad visszaadja a mozgó gépkocsi súlyát. Hívd az ős azonos nevű metódusát, és add hozzá az utasok súlyát
    //    (Ez lesz a visszatérési érték).
    //    Definiáld felül a toString metódust, a következő formára:
    //    Car{numberOfPassenger=4, vehicleWeight=1700}
    private int numberPassenger;

    public Car(int vehicleWeight, int numberPassenger) {
        super(vehicleWeight);
        this.numberPassenger = numberPassenger;
    }

    public int getNumberPassenger() {
        return numberPassenger;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad()+ numberPassenger*PERSON_AVERAGE_WEIGHT;
    }

    @Override
    public String toString() {
        return "Car{" + "numberOfPassenger=" + numberPassenger +", vehicleWeight="+ getVehicleWeight()+"}";
    }
}

