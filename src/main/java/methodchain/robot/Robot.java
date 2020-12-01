package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    //Egy Robot objektumot mozgatunk, utasításokat adva. Ezek menj és fordulj lehet.
    // Az utasítások láncban is kiadhatók, azaz a robot egyszerre több utasítást is kaphat, amit sorban végrehajt és ezzel egy adott távot megtéve, adott irányban áll meg.
    //
    //Hozz létre egy Robot osztályt, amiben legyen két attribútum: distance,
    // amelyben a megtett eddigi összes távolságot, és azimut amiben az aktuális irányszöget (fokban) tárolja.
    //
    //Publikus metódusok:
    //
    // public Robot go(int meter)
    // public Robot rotate(int angle)
    //Bónusz feladat
    //
    //Egészítsd ki a Robot osztályt azzal, hogy a robot a megfelelő utasításra feljegyzi az aktuális pozícióját
    // egy NavigationPoint objektumban, és ezt az objektumot hozzáadja egy listához.
    //
    //Kiegészítő publikus metódus:
    //
    // public Robot registerNavigationPoint()
    //
    //Így a robot mozgása utólag végigkövethető - feltéve, hogy kapott utasítást az adott pozícióban
    // ennek feljegyzésére a láncolt utasítások között. Ehhez a NavigationPoint objektumot
    // a robot aktuális távolságával és irányával (azimut) hozzuk létre, majd a robot listájához hozzáadjuk.
    // A teszteléshez a NavigationPoint objektumban meg kell írni a megfelelő toString metódust is.
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
        return this;
    }
    public Robot registerNavigationPoint(){
        navigationList.add(new NavigationPoint(getDistance(), getAzimut()));
        return this;
    }
}
