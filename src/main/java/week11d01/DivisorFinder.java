package week11d01;

public class DivisorFinder {

    public int findDivisors(int n){

        int numOfDivisors= 0;
        int digit;
        int rest= n;
        while(rest >0){
            digit= rest%10;
            rest= (rest- digit)/ 10;
            if(digit!= 0 && n% digit==0){
                numOfDivisors++;
            }
//            digit= rest%10;
//            rest= (rest- digit)/ 10;
        }
        return numOfDivisors;
    }
}
