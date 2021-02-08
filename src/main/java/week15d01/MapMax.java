package week15d01;

import java.util.Map;

public class MapMax {
    /*
    Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
    A map kulcsa az x koordináta értéke pedig az y koordináta.
    Döntsük el, hogy a kapott pontok küzül, hol van a függvénynek maximum helye és ott mennyi az értéke.
     */
    public Map.Entry maxOfMap(Map<Integer, Integer> graph){
//        int max= Integer.MIN_VALUE;
//        Map.Entry maxEntry= null;

        Map.Entry<Integer, Integer> maxEntry= null;
        for(Map.Entry<Integer, Integer> entry: graph.entrySet()){ // <Integer, Integer>
//            int actual= entry.getValue(); //  (Integer)entry.getValue();
//            if(actual > max){
//                max= actual;
//                maxEntry= entry;
//            }
            if(maxEntry==null || entry.getValue()> maxEntry.getValue()){
                maxEntry= entry;
            }
        }
        return maxEntry;
    }
}
