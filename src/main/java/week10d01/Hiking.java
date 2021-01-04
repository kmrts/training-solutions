package week10d01;

import java.util.List;

public class Hiking {

    /*
    Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Írj a week10d01.Hiking osztályba egy getPlusElevation() metódust, mely megkapja a magasságok listáját, és visszaadja
a emelkedések összegét. Azaz pl. 10,20,15,18 esetén 13, ugyanis (20 - 10) + (18 - 15). A 20 méterről 15 méterre ereszkedést nem számolja bele,
hiszen az ereszkedés, és nem emelkedés
     */

    public double getPlusElevation(List<Double> altitudes){
        if(altitudes==null){
            throw new IllegalArgumentException("could not be null");
        }
        double elev= 0;
        for(int i=1; i<altitudes.size(); i++){
            if(altitudes.get(i-1) < altitudes.get(i)){
                elev+= altitudes.get(i) - altitudes.get(i-1);
            }
        }
        return elev;
    }

//    public static void main(String[] args) {
//        System.out.println(getPlusElevation(List.of(10.0,20.,15.,18.)) );
//    }
}
