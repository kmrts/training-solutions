package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {//

        if(ssn.length()!=9){
            return false;
        }
        try{   ////
            int sum= 0;
            for(int i=0; i<ssn.length();i++){
                if(i%2==0){
                    //ptl
                    sum+= intFromChar(ssn.charAt(i))*3;
                }else{
                    sum+= intFromChar(ssn.charAt(i))*7;
                }
            }
            return sum%10 == ssn.charAt(8);
        }
        catch (IllegalArgumentException iae){ ///
            return false;
        }

    }
    public int intFromChar(char aChar){   //
        if (aChar < '0' || aChar > '9')
            throw new IllegalArgumentException("Not only numbers included.");
        return aChar - '0';
    }

}
