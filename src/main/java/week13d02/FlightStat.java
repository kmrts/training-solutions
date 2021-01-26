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
4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e. És egy Listába adjuk viassza az összes abba városba induló/érkező repülőt.
5. Adjuk vissza a legkorábban induló repülőt!
     */
    public void loadFlights(Path path){
        List<Flight> flightList= new ArrayList<>();
        try (BufferedReader brd = Files.newBufferedReader(path)) {
            String line;
            while ( (line= brd.readLine()) != null){

            }
        }catch (IOException e){
            throw new IllegalStateException("cannot read file", e);
        }
    }
    public Flight makeFlight(String line){
        String[] spl= line.split(" ");
        Flight f= new Flight(spl[0], stb)
        return null;
    }
}
