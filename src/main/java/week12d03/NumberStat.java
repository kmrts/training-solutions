package week12d03;

import java.util.Collections;
import java.util.List;

public class NumberStat {
    /*
    legyen egy metódus, ami paraméterül vár egy egész számokból álló listát.
    Add vissza azt a számot amelyik pontosan egyszer szerepel a listában.
    Ha több ilyen szám van akkor a kisebbet!
    Ellenőrizd, hogy olyan listát fogadunk el, ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma. A fent megírt metódus ezen a listán dolgozzon.
A lista elemeit fájlból töltsük fel. A file úgy néz ki, hogy egy sorban három szám van vesszővel elválasztva. Tehát:
1,1,4
2,3,5
2,2,5
     */
    public int onlyOneTime(List<Integer> numbers) {
        if (numbers.size() < 1) {
            throw new IllegalArgumentException("it's empty");
        }
        Collections.sort(numbers);

        int result = numbers.get(0); //Integer.MAX_VALUE;
        if (numbers.get(0) == numbers.get(1)) {
            result= numbers.get(numbers.size()-1);
        }

//        while (!found || i != numbers.size() - 2) {
        for(int i=1; i< numbers.size()-1; i++){
            int actual = numbers.get(i);
            if (actual != numbers.get(i - 1) && actual != numbers.get(i + 1)
                    && actual < result) {  //
                result = actual;

                return result;
            }

        }
        return result;
    }

}
