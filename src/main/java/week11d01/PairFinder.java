package week11d01;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {

    public int findPairs(int[] arr){
        if(arr==null){
            throw new IllegalArgumentException("Arr can not be null");
        }
        List<Integer> rest= new ArrayList<>();
        for(int item: arr){
            rest.add(item);
        }
//        System.out.println(rest);
        int actual;
        int sum= 0;
        while(rest.size()>1){

            actual= rest.get(0);
            rest.remove(0);
//            System.out.println(rest);
            for (int j = 0; j < rest.size() ; j++) {
//                System.out.println("j="+j);

                if(rest.get(j)== actual){
                    sum++;
                    rest.remove(j);
                    break;
                }
            }
        }
        return sum;
    }
}
