package exceptionmulticatch.converter;

public class BinaryStringConverter {
    /*
    Adatbázisban kódolva tárolunk több igaz, hamis értéket egyetlen szöveges adatban, ahol '0' karakter a hamis és '1' karakter az igaz.
    Készíteni kell tehát konvertert, amely átalakítja a szöveges adatot boolean tömb adattá.
    A konvertáláshoz két osztályt is kell készíteni. Legyen egy BinaryStringConverter osztály,
    amelynek van public boolean[] binaryStringToBooleanArray(String) és egy public String booleanArrayToBinaryString(boolean[]) metódusa.
    A String-ből konvertáló IllegalArgumentException-t dob, ha a String-ben nem csupa 0 és 1 van.
    A boolean[]-ből konvertáló pedig IllegalArgumentException-t dob, ha a tömb üres.

     */
    public boolean[] binaryStringToBooleanArray(String input){
        if(input==null){
            throw new IllegalArgumentException("binaryString null");
        }
        char nextChar;
        boolean[] resBool= new boolean[input.length()];
        for(int i=0; i<input.length(); i++){
            nextChar= input.charAt(i);
            if(nextChar!='1' && nextChar !='0'){
                throw new IllegalArgumentException("binaryString not valid");
            }
//            if(nextChar== '1'){
//                resBool[i]=true;
//            }
            resBool[i]= (nextChar== '1') ? true: false;

        }
        return resBool;
    }
    public String booleanArrayToBinaryString(boolean[] booleans){
        if(booleans==null|| booleans.length== 0){
            throw new IllegalArgumentException("array is null");
        }
        StringBuilder sb= new StringBuilder();
        for(boolean bool: booleans){
            if(bool){
                sb.append("1");
            }else{
                sb.append("0");
            }
        }
        return sb.toString();

    }

}
