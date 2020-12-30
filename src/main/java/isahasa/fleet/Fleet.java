package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    //Készíts egy Fleet osztályt, melynek van egy List<Ship> attribútuma, mely a hajókat tartalmazza.
    // A loadShip() metódusa végigmegy a listán, és sorban feltölti a hajókat a személyekkel és terhekkel.
    // A maradék személyeket és terheket (melyek nem fértek el) a waitingPersons és waitingCargo attribútumokban tárolja el.
    // Ez utóbbiakhoz generálj getter metódusokat is.
    private List<Ship> shipList= new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

//    public Fleet(List<Ship> shipList) {
//        this.shipList = shipList;
//    }
    public void addShip(Ship ship){  ///
        shipList.add(ship);
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

    public void loadShip(int passenger, int cargoWeight){
        waitingPersons= passenger;
        waitingCargo= cargoWeight;
        for(Ship ship: shipList){
            if(ship instanceof CanCarryPassengers){   ////instanceof
                if(waitingPersons!=0){  //ship.load..ból átalakul
                    waitingPersons= ((CanCarryPassengers) ship).loadPassenger(waitingPersons);
                }
            }
            if(ship instanceof CanCarryGoods){
                if(waitingCargo != 0){
                    waitingCargo= ((CanCarryGoods) ship).loadCargo(waitingCargo);
                }
            }
        }

    }
}
