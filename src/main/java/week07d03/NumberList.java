package week07d03;

import java.util.List;

public class NumberList {
    //Ennek legyen egy metódusa isIncreasing(List<Integer>) mely egy számokból álló listát vár paraméterül
    // és megnézi, hogy a listában a számok növekvő sorrendben szerepelnek-e és ennek megfelelően igaz vagy hamis értékkel tér vissza.
    // Speciális eset ha két egymást követő szám egyenlő, ez nem probléma a 1,2,3,3,3,5 számokat növekvőnek tekintjük.
    public static boolean isIncreasing(List<Integer> list){
        for(int i=1; i<list.size(); i++){
            if(list.get(i-1)> list.get(i)){
                return false;
            }
        }
        return true;
    }
}
