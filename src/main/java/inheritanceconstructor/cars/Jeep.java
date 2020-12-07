package inheritanceconstructor.cars;

public class Jeep extends Car{

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public void modifyFuelAmount(double fuel){
        if(fuel *-1 > extraFuel){

            setFuel(getFuel()+ fuel +extraFuel);  ///set
            extraFuel= 0;
        }else{
            extraFuel-= fuel;
        }

    }
    public void drive(int km){
        if(isEnoughFuel(km)){
            modifyFuelAmount(km* getFuelRate()/100 * -1);
        }else{
            throw new RuntimeException("Not enough fuel available!");
        }
    }
    public double calculateRefillAmount(){
        return getExtraCapacity()+getTankCapacity()- getFuel()- getExtraFuel();
    }
    public boolean isEnoughFuel(int km){
        return getExtraFuel()+getFuel() >= km* getFuelRate()/100 ? true : false;

    }
}
