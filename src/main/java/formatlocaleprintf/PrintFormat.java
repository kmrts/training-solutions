package formatlocaleprintf;

import java.util.Locale;
import java.util.MissingFormatArgumentException;

public class PrintFormat {
    public String checkException(String formatString, Integer i, Integer j){ ///
        try {
            return String.format(new Locale("hu", "HU"), formatString, i, j);
        } catch (MissingFormatArgumentException ex) {
            throw new IllegalArgumentException("Less objects then expected in format String!", ex);
        }

    }
    public String printFormattedText(Double number){
        String s= String.format("Total is: %,.2f Ft", number); ///
        return s;
    }
    public String printFormattedText(int count, String fruit){
        String s= String.format("We counted %d %s in the basket", count, fruit);
        return s;
    }
    public String printFormattedText(int number){
        String s= String.format("Right edge of numbers set at 4 spaces from text:%4d", number);///
        return s;
    }
    public String printFormattedText(Integer i, Integer j, Integer k){
        String s= String.format("Multiple objects containing text:%d\t%d\t%d", i, j, k); ///
        return s;
    }
}
