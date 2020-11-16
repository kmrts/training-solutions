package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String word){
        if(word==null){
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder sb= new StringBuilder(word.toLowerCase());
        String s = sb.toString().trim();
        String s2= sb.reverse().toString().trim();
        return s.equalsIgnoreCase(s2);

    }

}
