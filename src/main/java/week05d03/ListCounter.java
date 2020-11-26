package week05d03;

import java.util.List;

public class ListCounter {
    // egy kapott Listából (String) összeszámolja azokat amik 'a' vagy 'A' betűvel kezdődnek,
    //Ha nulla elemű a tömb,vagy nincs benne ilyen elem, akkor 0-t adjon vissza.

    public int startsWhithA(List<String> stringList){
        int numOfA=0;
        for (String item: stringList){
            if(item.toLowerCase().charAt(0)=='a'){
                numOfA++;
            }
        }
        return numOfA;
    }
}
