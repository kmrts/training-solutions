package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    //(óránként indul, generáláskor az első indulás óráját,
    // az utolsó indulás óráját, és az ismétlődő perceket kell megadni).
    List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }
    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        for(int i=firstHour; i<=lastHour; i++){
            this.timeTable.add(new SimpleTime(i, everyMinute));
        }
    }
    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }
    public SimpleTime nextBus(SimpleTime actual){
        for(SimpleTime st: timeTable){
            if(st.difference(actual)>=0){
                return st;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }
}
