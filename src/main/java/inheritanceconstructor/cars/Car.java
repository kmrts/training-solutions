package inheritanceconstructor.cars;

public class Car {
    // A Jeep abban különbözik ősosztályától,
    // hogy üzemanyagot nem csak a tankban, hanem kannákban is tud szállítani.
    // Felhasználáskor mindig először a kannákat ürítjük ki, utána a tankban levő üzemanyag mennyisége csökken.
    //
    private double fuelRate; // l /100 km
    private double fuel;
    private double tankCapacity;


    public Car(double fuelRate, double fuel, double tankCapacity) {
        if(tankCapacity< fuel){
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setFuelRate(double fuelRate) {
        this.fuelRate = fuelRate;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel){
        this.fuel+=fuel;
    }
    public void drive(int km){
        if(isEnoughFuel(km)){
            modifyFuelAmount(km* fuelRate/100 * -1);
        }else{
            throw new RuntimeException("Not enough fuel available!");
        }
    }
    public double calculateRefillAmount(){
        return tankCapacity -fuel;
    }
    public boolean isEnoughFuel(int km){
        return getFuel()>=km* fuelRate/100 ? true : false;

    }
}
