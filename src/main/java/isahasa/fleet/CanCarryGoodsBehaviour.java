package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {

    //A CanCarryGoodsBehaviour implementálja a CanCarryGoods interfészt.
    // Ennek az osztálynak két attribútuma van: int cargoWeight és int maxCargoWeight.
    // Implementáld a loadCargo(int weight) metódust, melynek paramétere a betöldendő rakomány súlya,
    // és a weight attribútumba eltárolja a letárolt rakományt, és visszatér a le nem tárolt rakomány súlyával.
    //
    //Vezessünk be egy CanCarryPassengersBehaviour osztályt, ami implementálja a CanCarryPassengers interfészt.
    // Ennek az osztálynak két attribútuma van: int passengers és int maxPassengers.
    // Implementáld a loadPassenger metódust, melynek paramétere a beszálló utasok száma,
    // és a passengers attribútumba letárolja a beszállt utasok számát, és visszatér a kintmaradó utasok számával.
    private int cargoWeight;
    private int maxCargoWeight;

    @Override
    public int loadCargo(int weight) {
        cargoWeight= (weight> maxCargoWeight) ? maxCargoWeight : weight;
        return weight- cargoWeight;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }

    //
    //A Liner osztály implementálja a Ship és a CanCarryPassengers interfészt, és legyen egy CanCarryPassengers típusú attribútuma.
    //
    //A CargoShip osztály implementálja a Ship és a CanCarryGoods interfészt, és legyen egy CanCarryGoods típusú attribútuma.
    //
    //A FerryBoat osztály implementálja a Ship, CanCarryGoods, CanCarryPassengers interfészt, és legyen mindkét típusú attribútuma.
    //
    //Mindhárom osztálynak legyen olyan konstruktora, mely elvárja a CanXxxBehaviour osztályok konstruktorában elvárt adatokat.
    //
    //Minden szükséges (interfész által kikényszerített) metódust úgy implementálj, hogy delegáld a kérést a megfelelő attribútum megfelelő metódusának.
    //
    //Azaz pl. a FerryBoat osztály loadCargo() metódusa hívja a CanCarryGoods loadCargo() metódusát.
    //
    //Készíts egy Fleet osztályt, melynek van egy List<Ship> attribútuma, mely a hajókat tartalmazza. A loadShip() metódusa végigmegy a listán, és sorban feltölti a hajókat a személyekkel és terhekkel. A maradék személyeket és terheket (melyek nem fértek el) a waitingPersons és waitingCargo attribútumokban tárolja el. Ez utóbbiakhoz generálj getter metódusokat is.
}


