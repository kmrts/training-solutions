package week13d05;

import java.util.*;

public class LetterCount {
    /*
    Junior (adatszerkezetes) feladat:
Írj egy metódust, amely megszámolja, hogy hány különböző betű van
egy szóban. A kis és nagybetűk közötti különbség nem számít!
A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az
angol ábécé betűit! (edited)
     */
    public int countHowManyConcreteLetters(String word){

        Set<Character> characterSet= new HashSet<>();

        for(Character ch: word.toLowerCase().toCharArray()){


                if(ch.charValue()>= 97 && ch.charValue()<=122){  // a 97, z 122
                    characterSet.add(ch);
            }

        }
        return characterSet.size();

    }

    public static void main(String[] args) {
        LetterCount lc= new LetterCount();
        System.out.println(lc.countHowManyConcreteLetters("mi a fEnének hogyan eddig")); //12
        System.out.println(lc.countHowManyConcreteLetters("Mucho Gusto"));  //8

    }
}
