package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    //A mozgatandó katona megtalálását és áthelyezését privát segédmetódusok végzik.
    //Minden publikus metódus ellenőrizze a paraméterként kapott adatokat. Objektum sehol sem lehet null,
    // illetve a Trooper neve nem lehet üres. Hibás paraméter esetén a metódus dobjon IllegalArgumentException kivételt!
    //
    //Mely metódusoknak van és melyeknek nincs visszahatása?

    List<Trooper> troopers = new ArrayList<>();

//    public HeadQuarter(List<Trooper> troopers) {
//        this.troopers = troopers;
//    }

    public List<Trooper> getTroopers() {
        return troopers;
    }
    public void addTrooper(Trooper trooper){
        if(trooper== null){
            throw new NullPointerException("Trooper cannot be null");
        }
        troopers.add(trooper);
    }

    public void moveClosestTrooper(Position target){
        if(target== null){
            throw new NullPointerException("The target cannot be null");
        }
        moveTrooper(findClosestTrooper(target), target);
    }

    public void moveTrooperByName(String name, Position target){
        if(target== null){
            throw new NullPointerException("The target cannot be null");
        }
        moveTrooper(findTrooperByName(name), target);
    }

    private Trooper findTrooperByName(String name){
        for(Trooper t: troopers){
            if(t.getName()== name){
                return t;
            }
        }
        return null;
    }
    private Trooper findClosestTrooper(Position target){
        double closest= Double.MAX_VALUE;
        Trooper closestTrooper = null;
        for(Trooper t: troopers){
            if(t.distanceFrom(target) < closest){
                closest= t.distanceFrom(target);
                closestTrooper = t;
            }
        }
        return closestTrooper;
    }
    private void moveTrooper(Trooper trooper, Position target){
        trooper.changePosition(target);
    }
}
