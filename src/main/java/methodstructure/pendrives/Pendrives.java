package methodstructure.pendrives;

import java.util.List;

public class Pendrives {
    //A Pendrives részletei: A metódusokat úgy implementáld, hogy nem hívod a Pendrive getPrice() metódusát.
    //
    //    Legyen Pendrive best(List<Pendrive>) metódusa, amely a legjobb ár/kapacitás értékű pendrive-t adja vissza,
    //    azaz amelyiknél ez a legkisebb.
    //    Legyen Pendrive cheapest(List<Pendrive>) metódusa, amely a legolcsóbbat adja vissza.
    //    Legyen void risePriceWhereCapacity(List<Pendrive>, int percent, int capacity) metódusa,
    //    amely adott százalékkal megemeli azon pendrive-ok árát, amelynek a kapacitása a megadott értékkel megegyezik.

    public Pendrive best(List<Pendrive> pendriveList){
        Pendrive best= null;
        for(Pendrive p: pendriveList){
            if(best==null || p.pricePerCapacity() < best.pricePerCapacity()){
                best= p;
            }
        }
        return best;
    }
    public Pendrive cheapest(List<Pendrive> pendriveList){
        Pendrive cheapest= null;
        for(Pendrive p: pendriveList){ //nem hívod a Pendrive getPrice() metódusát.
            if(cheapest==null || p.pricePerCapacity()*p.getCapacity() < cheapest.pricePerCapacity()*cheapest.getCapacity()){
                cheapest= p;
            }
        }
        return cheapest;
    }
    public void risePriceWhereCapacity(List<Pendrive> pendriveList, int percent, int capacity) {
        for (Pendrive p : pendriveList) {
            if (p.getCapacity() == capacity) {
                p.risePrice(percent);
            }
        }
    }
}
