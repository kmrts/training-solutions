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

    public CanCarryGoodsBehaviour(int maxCargoWeight) {     ////
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int loadCargo(int weight) {
        cargoWeight = (weight > maxCargoWeight) ? maxCargoWeight : weight;
        return (weight > maxCargoWeight) ? weight - cargoWeight : 0;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }

}


