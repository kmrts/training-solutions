package week07d01.senior;

public class Fibonacci {
    /*
    Készíts egy osztályt Fibonacci néven! Legyen benne egy fib metódus, ami egy int n paramétert vár!
    A visszatérési értékünk legyen egy long szám, ami az n-edik fibonacci számot tartalmazza.
    (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az 1, 1.

Bónusz feladat: implementáld az algoritmust ciklus nélkül és mentsd el a részeredményeket egy statikus változóba!

Pontosítás: Ha n = 0, akkor 0-t adunk vissza, ha n = 1, akkor 1-et, ezért lesz a 2. elem szintén 1, mert 0 + 1 = 1
     */
    public long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);

    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        System.out.println(fibo.fib(1));
        System.out.println(fibo.fib(0));
        System.out.println(fibo.fib(2));
        System.out.println(fibo.fib(3));
        System.out.println(fibo.fib(4));
        System.out.println(fibo.fib(5));
    }
}
