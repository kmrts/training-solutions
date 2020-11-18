package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {
//    Hozz létre egy IntegerMaxCalculator osztályt, valamint benne egy metódust, ami a kapott egész számok listájából kiválasztja a legnagyobbat.

    public int max(List<Integer> integerList){
        int max= Integer.MIN_VALUE;

        for (int item: integerList){
            if (item > max){
                max = item;
            }
        }
        return max;
    }

}

