package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    /*
    Ez fogja a futárt reprezentálni. Legyen egy rides listája ami fuvarokat tárol.
Legyen egy addRide metódus, ami csak sorrendben enged hozzáadni elemeket a listához.
Figyeljünk viszont arra, hogy nem feltétlenül minden nap dolgozott a futár, de ha már bekerült egy 3. napi fuvar,
akkor ne kerülhessen be egy 2. napi. És arra is figyelj, hogy a napon belül is sorrendben kerüljenek be az adatok.
Ha a paraméterül kapott Ride nem felel meg a feltételeknek dobjunk IllegalArgumentException-t.
pl egy helyes listára: 1 1 12 1 2 11 2 1 10 4 1 19
Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott. Ha több ilyen nap is van akkor a korábbit!
     */
    List<Ride> rides = new ArrayList<>();

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride newRide) {
        if (rides.size() > 0) {
            int lastIndex = rides.size() - 1;
            if (rides.get(lastIndex).getDay() > newRide.getDay() ||
                    (rides.get(lastIndex).getDay() == newRide.getDay() && rides.get(lastIndex).getNumber() >= newRide.getNumber())) {
                throw new IllegalArgumentException("There was an earlier");
            }
            if(rides.get(lastIndex).getDay()== newRide.getDay() && rides.get(lastIndex).getNumber() +1 != newRide.getNumber()){
                throw new IllegalArgumentException(String.format( "The next ride's number should be %d", rides.get(lastIndex).getNumber() +1 ));
            }
            if(rides.get(lastIndex).getDay() +1== newRide.getDay() && newRide.getNumber() != 1){
                throw new IllegalArgumentException("1st ride of day must be number 1");  // e két kieg, de 1. elemnél így nem vizsgál
            }
        }
        rides.add(newRide);
    }

    public int earlierDayNoRides() {
        int day = 0;
//        for(int i=1; i<rides.size()-1; i++){
//            if(rides.get(i).getDay()> rides.get(i+1).getDay()+1){
//                day= rides.get(i).getDay();
//                return day;
//            }
//        }
        for (Ride r : rides) {

            if (r.getDay() > day + 1) {
                return day+1;
            }
            day= r.getDay();
        }

        throw new IllegalArgumentException("There is not such a day");
    }
}
