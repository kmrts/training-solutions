package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    //A SimpleBag osztály egy tetszőleges számú Object típusú objektumot tartalmazó adatszerkezetet
    // reprezentál, a Book és Beer osztályok a kipróbálását segítik.
    // A tartalmazott objektumok között lehetnek azonosak is.
    // A SimpleBag osztály a tartalmazott objektumokat egy List<Object> items attribútumban tárolja,
    // és saját metódusai vannak az adatszerkezet kezelésére.
    // Az adatszerkezet bejárása a "kurzor" szemlélettel lehetséges.
    // A kurzor a létrehozáskor az első elem előtt áll, és bármikor újra ide helyezhető
    // a beforeFirst metódus meghívásával. Azaz a bejárás megismételhető.
    //
    //publikus metódusok:
    //
    // public SimpleBag()
    // public void putItem(Object item)
    // public boolean isEmpty()
    // public int size()
    // public void beforeFirst()
    // public boolean hasNext()
    // public Object next()
    // public boolean contains(Object item)
    // public int getCursor()
    private List<Object> items = new ArrayList<>();
    private int cursor= 0;

    public SimpleBag(List<Object> items) { //
        this.items = items;
    }

    public void putItem(Object item) {
        items.add(item);
    }

//    public boolean isEmpty() {
//
//    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = 0;
    }
}