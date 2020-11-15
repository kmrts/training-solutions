package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {

//    private List<Integer> numList= new ArrayList<>();

    public List<Integer> findDuplicates(List<Integer> numList) {
        List<Integer> dList = new ArrayList<>();
        for (int i = 1; i < numList.size(); i++) {  //=0 mego
            for (int j = 0; j < i; j++) {
                if (numList.get(i)==numList.get(j)) { // .equals() mego
                    dList.add(numList.get(i));
                    break; //
                }
            }
        }
        return dList;
    }

}
