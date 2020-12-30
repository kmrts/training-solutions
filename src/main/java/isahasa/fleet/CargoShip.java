package isahasa.fleet;

public class CargoShip implements Ship, CanCarryGoods{
    //
    //A CargoShip osztály implementálja a Ship és a CanCarryGoods interfészt, és legyen egy CanCarryGoods típusú attribútuma.
    //
    //A FerryBoat osztály implementálja a Ship, CanCarryGoods, CanCarryPassengers interfészt,
    // és legyen mindkét típusú attribútuma.
    private CanCarryGoods canCarryGoods;

    public CargoShip(int maxCargoWeight) {   ///
        canCarryGoods= new CanCarryGoodsBehaviour(maxCargoWeight);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }
}
