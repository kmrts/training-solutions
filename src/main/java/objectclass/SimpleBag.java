package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    // A kurzor a létrehozáskor az első elem előtt áll, és bármikor újra ide helyezhető
    // a beforeFirst metódus meghívásával. Azaz a bejárás megismételhető.

    private List<Object> items = new ArrayList<>();
    private int cursor= 0; //-1

    public SimpleBag() { //
        beforeFirst(); //
    }

    public void putItem(Object item) {
        items.add(item);
        cursor++;
    }

    public boolean isEmpty() {
        return items.size()==0;

    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = 0;  //-1
    }
    public boolean hasNext(){
        return items.size()>cursor; //items.get(cursor)!= null
    }
    public Object next(){
        cursor++;
        return items.get(cursor-1);

    }
    public boolean contains(Object item){  //.contains
//        items.contains(item);
        for(Object obj: items){
            if(obj.equals(item)){ //nem==
                return true;
            }
        }
        return false;
    }

    public int getCursor() {
        return cursor;
    }
}