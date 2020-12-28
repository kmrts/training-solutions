package interfacestaticmethods;

import java.util.List;

public interface Valued {
    //Készíts egy Valued interfészt, mely egyetlen absztrakt metódust definiál.
    // A getValue() metódus egy Valued példány értékét adja meg.
    // Hozz létre az interfészben egy sum() metódust, mely paraméterként egy List<Valued> típusú adatot kap,
    // és a benne található elemek összértékét számítja ki!
    double getValue();
    static double totalValue(List<Valued> valuedList) {  //static és van body
        double sum= 0;
        for(Valued v: valuedList){
            sum+= v.getValue();
        }
        return sum;
    }

}
