package isahasa.fleet;

public interface Ship {
    //A flottában vegyesen vannak teherszállító hajók (cargo ship), személyszállító hajók (liner)
    // és kompok (ferry boat).
    // A kompok személyeket és terhet is szállíthatnak.
    // Ha a flotta behajóz, akkor folyamatosan töltik fel a hajókat, mindaddig, amíg meg nem telnek, el nem fogy az utas,
    // vagy teher.
    //
    //Hozz létre egy Ship interfészt, mely a hajót jelöli (marker interfész, metódus nélkül),
    // egy CanCarryGoods és CanCarryPassengers interfészt, mely azt jelöli,
    // hogy egy hajó tud-e személyeket, vagy terhet szállítani.
    // A CanCarryGoods interfészben hozz létre egy int loadCargo(int cargoWeight) és int getCargoWeight() metódust.
    // A CanCarryPassengers interfészben egy int loadPassenger(int passengers) és egy int getPassengers() metódust.
    //
    //A CanCarryGoodsBehaviour implementálja a CanCarryGoods interfészt. Ennek az osztálynak két attribútuma van: int cargoWeight és int maxCargoWeight. Implementáld a loadCargo(int weight) metódust, melynek paramétere a betöldendő rakomány súlya, és a weight attribútumba eltárolja a letárolt rakományt, és visszatér a le nem tárolt rakomány súlyával.
    //
    //Vezessünk be egy CanCarryPassengersBehaviour osztályt, ami implementálja a CanCarryPassengers interfészt. Ennek az osztálynak két attribútuma van: int passengers és int maxPassengers. Implementáld a loadPassenger metódust, melynek paramétere a beszálló utasok száma, és a passengers attribútumba letárolja a beszállt utasok számát, és visszatér a kintmaradó utasok számával.
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
