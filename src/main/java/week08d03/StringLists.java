package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {
    //week08d03 csomagban egy StringLists osztályt és benne egy stringListsUnion(List<String> first, List<String> second) metódust,
    // mely két string listát vár paraméterül és visszaadja az uniójukat.
    // Az úniónak minden elemet tartalmaznia kell mindkét listából, de egy elem nem szerepelhet kétszer!

    private List<String> union= new ArrayList<>();

    public List<String> stringListsUnion(List<String> first, List<String> second){
        union= first;
        for(String s: second){
            if(!union.contains(s)){
                union.add(s);
            }
        }
        return union;
    }

}
