package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int distance;
    private int azimut;

    private List<NavigationPoint> navigationList= new ArrayList<>();

//    public Robot(int distance, int azimut) {
//        this.distance = distance;
//        this.azimut = azimut;
//    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationList;
    }

    public Robot go(int meter){
        distance+= meter;
        return this;
    }
    public Robot rotate(int angle){
        azimut= (azimut+ angle)% 360;
        if(azimut<0){       //
            azimut+=360;
        }
        return this;
    }
    public Robot registerNavigationPoint(){
        navigationList.add(new NavigationPoint(getDistance(), getAzimut()));
        return this;
    }
}
