package primitivetypes;

import java.sql.SQLOutput;

public class PrimitiveTypes {

    public String toBinaryString(int n){
        int numOfDigits= 32;
        String sumDigit= "";
        for (int i=n; i>0; i/=2){

            int digit= i%2;
            sumDigit= digit+ sumDigit;

        }
        if (sumDigit.length() < numOfDigits){
            int nulls= numOfDigits - sumDigit.length();

            for(int i=0;i< nulls; i++){
                sumDigit= "0"+ sumDigit;
            }
        }
        return sumDigit;
    }
}
