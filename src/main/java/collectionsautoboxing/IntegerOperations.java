package collectionsautoboxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerOperations {
    /*
    Implementáld az IntegerOperations osztályban a következő metódusokat!

public List<Integer> createList(int... numbers)
public int sumIntegerList(List<Integer> integerList)
public int sumIntegerObjects(Integer... integers)

Az egyes kollekciók esetében vizsgáljuk meg és értelmezzük a toString() metódus működését, a kiírás sorrendjének elemzésével.
Megvalósítás

Használjunk varargs típusokat a paraméterek megadásához.
     */
    public List<Integer> createList(int... numbers){
        List<Integer> integerList= new ArrayList<>();
        for(int i: numbers){
            integerList.add(i);
        }
//        return new List<>(Arrays.asList(numbers)) ;
        return integerList;
    }
    public int sumIntegerList(List<Integer> integerList){
        int sum=0;
        for(Integer i: integerList){
            sum+= i;
        }
        return sum;

    }
    public int sumIntegerObjects(Integer... integers){
        int sum=0;
        for(Integer i: integers){
            sum+= i;
        }
        return sum;

    }
}
