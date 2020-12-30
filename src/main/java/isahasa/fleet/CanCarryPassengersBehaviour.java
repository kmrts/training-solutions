package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers{
    private int passengers;
    private int maxPassengers;  //final

    public CanCarryPassengersBehaviour(int maxPassengers) {   ///
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        this.passengers= (passengers> maxPassengers) ? maxPassengers : passengers;
        return (passengers> maxPassengers) ? passengers- maxPassengers : 0;
    }

    @Override
    public int getPassengers() {
        return this.passengers;
    }
}
