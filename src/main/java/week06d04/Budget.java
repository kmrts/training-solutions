package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    //a konstruktorában Item példányokat vár listában (List).
    // Az Item tartalmazza az alábbi attribútumokat: int price, int month, String name.
    // A Budget osztály tárolja el egy attribútumban a konstruktorban megkapott items listát.
    // Írjunk egy metódust, getItemsByMonth néven, mely egy hónapot vár (1-12) és visszaadja az Itemeket az adott hónapban!
    // Bónusz feladat: ellenőrizzük a bemeneti paramétereket és írjunk tesztet!

    List<Item> items= new ArrayList<>();

    public Budget(List<Item> items) {
//        if(items.isEmpty()){
        if(items== null){
            throw new NullPointerException("Items cannot be null.");
        }

//        }
        this.items = items;
    }
    public List<Item> getItemsByMonth(int month){
        if(month<1 || month>12){
            throw new IllegalArgumentException("Month have to be 1 - 12");
        }
        List<Item> resItems= new ArrayList<>();

        for(Item i: items){
            if(i.getMonth()==month){
                resItems.add(i);
            }
        }
        return resItems;
    }
}
