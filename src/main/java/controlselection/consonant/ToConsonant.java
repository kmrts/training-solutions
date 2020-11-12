package controlselection.consonant;

public class ToConsonant {
    public static final String VOWS = "aeiou";

    public char toC (char c) {
        if (VOWS.indexOf(c) != -1) {
            return (char) (c + 1);
        }
        else {
            return c;
        }
    }

    public static void main(String[] args) {
        ToConsonant tc= new ToConsonant();

        System.out.println(tc.toC('i'));
        System.out.println(tc.toC('w'));
    }
}
