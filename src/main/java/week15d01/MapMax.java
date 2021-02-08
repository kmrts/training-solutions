package week15d01;

import java.util.Map;

public class MapMax {
    /*
    Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben.
    A map kulcsa az x koordináta értéke pedig az y koordináta.
    Döntsük el, hogy a kapott pontok küzül, hol van a függvénynek maximum helye és ott mennyi az értéke.
     */
    public Map.Entry maxOfMap(Map<Integer, Integer> graph){
        int max= Integer.MIN_VALUE;
        Map.Entry maxEntry;
//        for(int y: graph.values()){
//            if( y> max){
//                max= y;
//                maxEntry= graph.g
//            }
//        }
        for(Map.Entry entry: graph.entrySet()){
            if(entry.getValue() > max){

            }
        }
        return graph.(max);
    }
}
