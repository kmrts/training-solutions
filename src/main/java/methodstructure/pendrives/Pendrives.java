package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

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
        for(Pendrive p: pendriveList){ //nem hívod a Pendrive getPrice() metódusát.  //cheaperThan-ra utalt
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
