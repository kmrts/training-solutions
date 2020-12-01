package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {

    private String name;
    private Time openingTime;

    public Pub(String name, int hours, int minutes){
        this.name= name;
        this.openingTime= new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return openingTime;
    }

    @Override
    public String toString() {//Kurta kocsma;10:30
        return String.format("%s;%d:%d",name, openingTime.getHours(), openingTime.getMinutes());
    }

}
