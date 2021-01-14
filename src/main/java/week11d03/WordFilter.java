package week11d03;

import abstractclass.gamecharacter.Character;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {
    /*
    Készíts egy WordFilter osztályt, melyben van egy List<String> wordsWithChar(List<String> words, char c) metódus.
    A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter,
    majd ezeket visszaadja egy listában.
     */
    public List<String> wordsWithChar(List<String> words, char c){
        if(words== null){
            throw new IllegalArgumentException("can not be null");
        }
        List<String> results= new ArrayList<>();
        for (String str: words){
            if(str.contains(String.valueOf(c)) ){
                results.add(str);
            }
//            char[] chars= str.toCharArray();
//            for(char ch: chars){
//                if(ch ==c){
//                    results.add(str);
//                    break;
//                }
//            }
        }
        return results;
    }
}
