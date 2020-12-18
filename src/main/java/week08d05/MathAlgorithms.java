package week08d05;

public class MathAlgorithms {
    //készíts egy osztályt MathAlgorithms néven. Legyen benne egy metódus, greatestCommonDivisor() ,
    // ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.
    public int greatestCommonDivisor(int a, int b){
        if(a<0 || b<0){
            throw new IllegalArgumentException("we need positive whole numbers");
        }
        int limit;
        limit= (a<=b) ? a : b; //
        int lnko= 1;
        for(int i=2; i<= limit/2; i++){
            if(a%i==0 && b%i==0){
                lnko= i;
            }
        }
        return lnko;
    }

}
