package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FlightStat {
    /*
    https://training360-talk.slack.com/files/U01DDAF4QHX/F01KFP044DV/junior0126.md?origin_team=T01BZA8QS59&origin_channel=C01G9M2ER5M

    https://training360-talk.slack.com/files/U01DDAF4QHX/F01LLBQH4G0/cities.txt?origin_team=T01BZA8QS59&origin_channel=C01G9M2ER5M

    Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy felszálló gépről van-e szó.
    A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás/leszállás pontos ideje.
​
A fájl:
FC5354 Arrival Dublin 18:16
KH2442 Departure Berlin 15:54
ID4963 Departure Amsterdam 15:22
CX8486 Arrival Brussels 10:37
EJ9251 Departure  Toronto 11:30
KJ7245 Departure Bern 6:18
JN6048 Arrival Moscow 18:39
MN5047 Arrival Athens 9:35
​
Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek a fájlban.
Feladatok:
1. Olvasd be a fájl tartalmát a memóriába.
2. Határozd meg, hogy induló vagy érkező járatból volt-e több.
3. Legyen egy metódus ami járatszám alapján ad vissza egy repülőt.
4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e.
És egy Listába adjuk viassza az összes abba városba induló/érkező repülőt.
5. Adjuk vissza a legkorábban induló repülőt!
     */
    List<Flight> flightList= new ArrayList<>();

    public List<Flight> getFlightList() {
        return new ArrayList<>(flightList);
    }

    public void loadFlights(Path path){   //1

        try (BufferedReader brd = Files.newBufferedReader(path)) {
            String line;
            while ( (line= brd.readLine()) != null){
                flightList.add(makeFlight(line));
            }
        }catch (IOException e){
            throw new IllegalStateException("cannot read file", e);
        }
    }
    private Flight makeFlight(String line){
        try{
            String[] spl= line.split(" ");
            FlightType type= null;
            if(spl[1].equals("Arrival")){
                type= FlightType.ARRIVAL;
            }else{
                type= FlightType.DEPARTURE;
            }
            return new Flight(spl[0], type, spl[2], spl[3]);

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Illegal argument");
        }

    }
    public String countArrivalVsDeparture(){  //2
        int countArri= 0;
        for(Flight fl: flightList){
            if(fl.getType().equals(FlightType.ARRIVAL)){
                countArri++;
            }
        }
        return String.format("Arrivals: %d, Departures: %d", countArri, flightList.size()- countArri);
    }
    public Flight flightFromNumber(String search){ //3
        for (Flight f: flightList){
            if(f.getNumber().equals(search)){
                return f;
            }
        }
        throw new IllegalArgumentException("There is not a flight with such number");
    }
    public List<Flight> flightsFromCityAndType(String city, FlightType type){  //4
        List<Flight> resList= new ArrayList<>();
        for (Flight f: flightList ) {
            if(f.getCity().equals(city) && f.getType()== type){
                resList.add(f);
            }
        }
        return resList;
    }
    public Flight earlyestFlight(){ //5
        int timeInMinutes; //= Integer.MAX_VALUE;
        int min= Integer.MAX_VALUE;
        int index= 0;
        for(int i=0; i<flightList.size(); i++){
            String[] splitted= flightList.get(i).getTime().split(":");
            timeInMinutes= Integer.parseInt(splitted[0] )*60+ Integer.parseInt(splitted[1]);
            if(timeInMinutes< min){
                min= timeInMinutes;
                index= i;
            }

        }
        return flightList.get(index);
    }
}
