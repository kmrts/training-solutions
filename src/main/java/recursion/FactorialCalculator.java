package recursion;

public class FactorialCalculator {

//    A matematikában egy n nemnegatív egész szám faktoriálisának az n-nél kisebb
//    vagy egyenlő pozitív egész számok szorzatát nevezzük. n! = n * (n-1) * ... * 2 * 1
//
//    Írd meg a faktoriális számítás algoritmusát rekurzívan.
    public long getFactorial(int n){
        if (n<=1){
            return 1;
        }else{
            long multip= getFactorial(n-1);
            return n* multip;
            }
        }

}
