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

    /*
        Az ár számolása úgy történik, hogy venni kell a hajóhoz tartozó alapárat,
        és meg kell szorozni az osztályhoz tartozó szorzóval, rendre 3,0, 1,8 és 1,0.

        bookPassenger(): egy foglalás. Ellenőrizni kell, hogy van-e még elég hely.
        getPriceForPassenger(): visszaadja, hogy mennyibe kerülne a foglalás. Ez a metódus még NEM foglal.
        findPassengerByName(): foglalás megkeresése név alapján
        getPassengerNamesOrdered(): visszaadja a foglalást végzők neveit ábécé sorrendben
        sumAllBookingsCharged(): összegzi, hogy mennyi az összes bevétel
        countPassengerByClass(): visszaadja, hogy osztályonként mennyien foglaltak

         */
    public void bookPassenger(Passenger passenger){
        if(boat.getMaxPassengers()> passengers.size()){
            passengers.add(passenger);
        }
    }
    public double getPriceForPassenger(Passenger passenger){
//        double sum= 0.0;
//        for(Passenger p: passengers){
//            sum+= basicPrice* p.getCruiseClass().getValue();
//        }
//        return sum;
        return basicPrice* passenger.getCruiseClass().getValue();
    }
    public Passenger findPassengerByName(String name){
       for(Passenger p: passengers){
           if(p.getName().equals(name)){
               return p;
           }
       }
       throw new IllegalArgumentException("Nincs ilyen utas");
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
