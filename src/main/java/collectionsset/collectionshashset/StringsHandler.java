package collectionsset.collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {
    /*
    Szolgáltatásokat készítünk, egyrészt egy nagy elemszámú, random módon generált String kollekcióból akarjuk kiszűrni
    az egyedi elemeket, másrész két különböző String halmazból akarjuk kinyerni a közös elemeket.

A StringsHandler osztályban a következő publikus metódusok találhatók (ezek persze a tesztesetekből is következnek):

public Set<String> filterUniqueStrings(Collection<String> stringCollection)
public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB)

    Feltételezzük, hogy a véletlenszerűen generált String objektumok között valamennyi azonos is található.
    Feltételezzük, hogy két (vagy több) egyénileg, véletlenszerűen generált String kollekcióban számos azonos String található.
     */
    public Set<String> filterUniqueStrings(Collection<String> stringCollection){
        Set<String> filtered= new HashSet<>();
        for(String s: stringCollection){
            filtered.add(s);
        }
//        Set<String> filtered = new HashSet<>(stringCollection);
        return filtered;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB){
//        Set<String> selected= new HashSet<>();
//        selected.addAll(setA);
//        selected.addAll(setB);
//        return selected;
// 360e kb

        setA.retainAll(setB);
        return setA;
// 203e kb
    }
}
