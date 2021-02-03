package week14d01;

import java.util.*;

public class Indexer {
    /*
    van egy public Map<Character, List<String>> index(List<String> names) metódusa.
    A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből (minden kezdőbetűt társítsunk az összes névvel,
    mely ezzel a betűvel kezdődik).
Példa:
System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
// {A=[Abraham], L=[Lujza], M=[Magdolna], O=[Odon]}
     */
    public Map<Character, List<String>> index(List<String> names){
        Map<Character, List<String>> nameMap= new HashMap<>();

        for(String name: names){
            char init= name.toUpperCase().charAt(0);
            if(nameMap.containsKey(init)){
//                nameMap.put(init, nameMap.get(init).add(name));  //nem műk

                nameMap.get(init).add(name);

//                List<String> nextList= nameMap.get(init);
//                nextList.add(name);
//                nameMap.put(init, nextList);

            }else{
                nameMap.put(init, new ArrayList<>(Arrays.asList(name)));  //Arrays.asList(name) nem jó
            }
        }
        return nameMap;
    }

    public static void main(String[] args) {
        Indexer i= new Indexer();
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "michele", "Anna", "Louie", "Ladislaw")));
    }
}
