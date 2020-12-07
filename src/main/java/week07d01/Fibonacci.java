package week07d01;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    //Legyen benne egy fib metódus, ami egy int n paramétert vár. A visszatérési értékünk legyen egy long szám, ami az n-edik fibonacci számot tartalmazza.
    // (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az 1, 1.
    //Bónusz feladat: implementáljuk az algoritmust ciklus nélkül és mentsük el a részeredményeket egy statikus változóba.
    //Pontosítás: Ha n = 0, akkor 0-t adunk vissza, ha n=1, akkor 1-et, ezért lesz a 2. elem szintén 1, mert 0 + 1 = 1

    static List<Long> sub = new ArrayList<>();  //no long but Long

    public long fib(int n) {
        long temp=0;
        if (n == 0) {
            temp=0;
        } else if (n == 1) {
            temp=1;

        } else {
            temp= fib(n-2) + fib(n-1);

        }
        sub.add(temp);
        return temp;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(7));
        System.out.println(sub.subList(sub.size()-7, sub.size()-1));   //subList(sub.size()-5)
    }
}
