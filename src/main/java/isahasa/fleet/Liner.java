package isahasa.fleet;

public class Liner implements Ship, CanCarryPassengers{
    //A Liner osztály implementálja a Ship és a CanCarryPassengers interfészt,
    // és legyen egy CanCarryPassengers típusú attribútuma.
    private CanCarryPassengers canCarryPassengers;

    public Liner(int maxPassenger) {
        canCarryPassengers= new CanCarryPassengersBehaviour(maxPassenger);
    }

    @Override
    public int loadPassenger(int passengers) {  //delegate, not implem., not override
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
    //Mindhárom osztálynak legyen olyan konstruktora, mely elvárja a CanXxxBehaviour osztályok konstruktorában elvárt adatokat.
    //
    //Minden szükséges (interfész által kikényszerített) metódust úgy implementálj,
    // hogy delegáld a kérést a megfelelő attribútum megfelelő metódusának.
    //
    //Azaz pl. a FerryBoat osztály loadCargo() metódusa hívja a CanCarryGoods loadCargo() metódusát.


}
