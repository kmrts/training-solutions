package stringscanner;

import java.util.Scanner;

public class StringScanner {
    public int readAndSumValues(String intString, String delimiter){
        if(isEmpty(intString) || isEmpty(delimiter)){
            throw new IllegalArgumentException("Illegal argument!");
        }
        Scanner s= new Scanner(intString).useDelimiter(delimiter);
        int sum=0;
        while(s.hasNextInt()){
            int value= s.nextInt();
            sum+= value;
        }
        return sum;
    }
    public int readAndSumValues(String intString){
        if(isEmpty(intString)){
            throw new IllegalArgumentException("Illegal argument!");
        }
        Scanner s= new Scanner(intString);
        int sum=0;
        while(s.hasNextInt()){
            int value= s.nextInt();
            sum+= value;
        }
        return sum;
    }
    public String filterLinesWithWordOccurrences(String text, String word){
        if(isEmpty(text) || isEmpty(word)){
            throw new IllegalArgumentException("Illegal argument!");
        }
        Scanner s= new Scanner(text);
        while(s.hasNextLine()){
            String row=s.nextLine();

        }
        return null;
    }

    public boolean isEmpty(String s){
        if(s==null || "".equals(s)){
            return true;
        }
        return false;
    }
}
