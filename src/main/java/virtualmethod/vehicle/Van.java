package virtualmethod.vehicle;

public class Van extends Car{

    //
    //Hozz létre egy Van osztályt, amely egy kisteherautót modellez. Ez az osztály az általános autóból származik,
    // kiterjeszti a Car osztályt.
    //
    //    Tartalmaz egy cargoWeight egész attribútumot a rakomány súlyának tárolására.
    //    Definiálj egy konstruktort, amely megkapja a rakománysúlyt, és az ős osztály
    //    két attribútumához szükséges értékeket is (összesen három egész érték).
    //    Hívd a super-t az ős attribútumok inicilizálására, és állítsa be az új attribútumot is.
    //    Definiáld felül a getGrossLoad metódust.
    //    Hívd az ős azonos nevű metódusát, és add hozzá a rakomány súlyát (Ez lesz a visszatérési érték).
    //    Definiáld felül a toString metódust, a következő formára:
    //    Van{cargoWeight=1222, numberOfPassenger=4, vehicleWeight=1200}
    //
    //Virtuális metódusok használata (Mindig az hívódik, amelyikre szükség van.)
    private int cargoWeight;

    public Van(int vehicleWeight, int numberPassenger, int cargoWeight) {
        super(vehicleWeight, numberPassenger);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() +cargoWeight;
    }

    @Override
    public String toString() {  //Van{cargoWeight=1222, numberOfPassenger=4, vehicleWeight=1200}
        return "Van{cargoWeight="+ cargoWeight +", numberOfPassenger="+ getNumberPassenger()
                +", vehicleWeight="+ getVehicleWeight()+ "}";
    }
}
