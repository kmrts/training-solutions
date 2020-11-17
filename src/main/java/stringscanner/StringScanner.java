package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {
    public int readAndSumValues(String intString, String delimiter){

        try (Scanner s= new Scanner(intString)){  ///
            if(!isEmpty(delimiter)){
                s.useDelimiter(delimiter);
            }
            int sum=0;
            try {
                while (s.hasNext()) {  //
                    sum += s.nextInt();
                }
            }
            catch (InputMismatchException ex){
                throw new IllegalArgumentException("Incorrect parameter string!");
            }

            return sum;
        }


    }
    public int readAndSumValues(String intString){  ///
        return readAndSumValues(intString, null);

    }
    public String filterLinesWithWordOccurrences(String text, String word){
        if(isEmpty(text) || word== null || "".equals(word) ){  ///
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner s= new Scanner(text);
        String filtered="";
        while(s.hasNextLine()){
            String row=s.nextLine();

            if(row.contains(word)){
                filtered+=row;
                filtered+="\n";
            }

        }
        return filtered.toString().trim();   //uts 2 nélkül nem
    }

    public boolean isEmpty(String s){
        if(s==null || "".equals(s.trim())){  ///kell a trim()
            return true;
        }
        return false;
    }
}
