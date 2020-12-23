package week09d02;

public class FibCalculator {
    //készíts egy osztályt FibCalculator néven. Ennek legyen egy metódusa long sumEvens(int bound) néven.
    // Ennek a metódusnak a feladata az, hogy összeadja a páros fibonacci számokat addig,
    // amig a következő fibonacci szám nem nagyobb, mint bound, majd visszadja a végredményt.
    public long sumEvens(int bound){
        long sumFib= 0;
        int fib0= 1;
        int fib1= 2;
        int nextFib;
        while(fib1<=bound){
//            System.out.println(fib1);
            if(fib1%2==0){
                sumFib+= fib1;
            }
            nextFib= fib0+ fib1;
            fib0= fib1;
            fib1= nextFib;

        }
        return sumFib;
    }

    public long sumEvensTillThous(){
        long sumFib= 0;
        int fib0= 1;
        int fib1= 2;
        int nextFib;
        while(sumFib <=1_000_000){
            System.out.print(fib1 +", ");
            if(fib1%2==0){
                sumFib+= fib1;
            }
            nextFib= fib0+ fib1;
            fib0= fib1;
            fib1= nextFib;

        }
        return sumFib;
    }
    //1,1 2 3 5 8 13 21 34 55 89 144


}
