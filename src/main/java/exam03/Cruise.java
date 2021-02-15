package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers= new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public void bookPassenger(Passenger passenger){
        if(boat.getMaxPassengers()> passengers.size()){
            passengers.add(passenger);
        }else{
            throw new IllegalArgumentException("Boat is full");
        }
    }
    public double getPriceForPassenger(Passenger passenger){

        return basicPrice* passenger.getCruiseClass().getValue();
    }
    public Passenger findPassengerByName(String name){
       for(Passenger p: passengers){
           if(p.getName().equals(name)){
               return p;
           }
       }
       throw new IllegalArgumentException("No such passenger");
    }
    public List<String> getPassengerNamesOrdered(){
        List<String> names= new ArrayList<>();
        for(Passenger p: passengers){
            names.add(p.getName());
            Collections.sort(names);
        }
        return names;
    }
    public double sumAllBookingsCharged(){
        double sum = 0.0;
        for (Passenger p : passengers) {
            sum += basicPrice * p.getCruiseClass().getValue();
        }
        return sum;
    }
    public Map<CruiseClass, Integer> countPassengerByClass(){
        Map<CruiseClass, Integer> result= new HashMap<>();
        for (Passenger p: passengers){
            CruiseClass actual= p.getCruiseClass();
            if(result.containsKey( p.getCruiseClass())){
                result.put(actual, result.get(actual) +1);
            }else{
                result.put(actual, 1);
            }
        }
        return result;


    }
}
