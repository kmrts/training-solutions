package exam02;

public class ArraySelector {
    /*
    Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat,
    és egy szövegként összerak, szögletes zárójelek között!
A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.

Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
     */
    public String selectEvens(int[] input){
        String result= "[";
        for (int i = 0; i < input.length ; i++) {
//            result+= "[";
            if(i%2==0){
                result+= input[i]+", ";

            }

        }

        if(input.length==0){
            result="";
        }else{
            result= result.substring(0, result.length()-2);
            result+= "]";
        }
        return result;
    }
}
