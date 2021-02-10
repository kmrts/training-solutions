package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class QuizHandler {
    /*
    Adott egy vetélkedő kérdésbankja egy fájlban. A fálban az egy kérdéshez tartozó adatok két sorban helyezkednek el.
    Első sorban a kérdés, a második sorban a válasz a pontszám és a téma szóközzel elválasztava. Olvasd be a fájl tartalmát a memóriába,
    majd oldjátok meg a lenti feladatokat.

```
Mikor volt a mohacsi vesz?
1526 1 tortenelem
Melyik evben bomlott fel a Nyugat-Romai Birodalom?
476 1 tortenelem
Melyik a legkisebb primszam?
2 1 matematika
Mennyi 64 kobgyoke?
4 2 matematika
Hany atloja van a szabalyos nyolcszognek?
24 2 matematika
Melyik evben kezdodott a Honfoglalas?
895 1 tortenelem
Mikor adtak ki az Aranybullat?
1222 1 tortenelem
Melyik evben adtak ki Angliaban a Magna Chartat?
1215 3 tortenelem
```
1. Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.
3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy datszerkezetben amelyben témánként megtalálható az összes kérdés.
4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!
     */

    List<Quiz> quizList= new ArrayList<>();

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void readQuizItems(Path path){

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while( (line= br.readLine() )!= null){
                String question= line;
                line= br.readLine();
                String[] splt= line.split(" ");
                quizList.add(new Quiz(question, splt[0], splt[1], splt[2]));
            }
        }catch (IOException ioe){
            throw new IllegalArgumentException("can not read file", ioe);
        }
    }
    //1
    public List<String> quesFromTheme(String theme){
        List<String> quesList= new ArrayList<>();
        for(Quiz qu: quizList){
            if(qu.getTheme().equals(theme)){
                quesList.add(qu.getQuestion());
            }
        }
        return quesList;
    }
    // 2
    public Quiz randQuestion(){
        int size= quizList.size();
        Random rnd= new Random();
//        rnd.nextInt(size) ;  // no +1
        return quizList.get(rnd.nextInt(size));
    }
    //3
    public Map<String, List<Quiz> > questionsByThemes(){
        Map<String, List<Quiz>> resultMap= new TreeMap<>();
        for(Quiz qu: quizList){
            String actuTheme = qu.getTheme();
            if( !resultMap.containsKey( actuTheme)){
                resultMap.put(actuTheme, new ArrayList<>());
            }
            List<Quiz> actualList= resultMap.get(actuTheme);
            actualList.add( qu);
            resultMap.put(actuTheme, actualList);

        }
        return resultMap;
    }
    //4
    public String maxSumPointedTheme(){
        Map<String, List<Quiz>> quizMap =questionsByThemes();
        int maxSum= 0;
        String result= null;
        for(Map.Entry<String, List<Quiz>> entry: quizMap.entrySet()){
            int actual= sumPoint(entry.getKey(), entry.getValue());
            if(result==null || actual> maxSum){
                maxSum= actual;
                result= entry.getKey();
            }
            System.out.print(entry.getKey()+ " " +actual+ " ");
        }
        return result;
    }
    private int sumPoint(String theme, List<Quiz> quizList){
        int sum= 0;
        for(Quiz q: quizList){
//            if(theme.equals( q.getTheme())){
//                sum++;
//            }
            sum+= Integer.parseInt( q.getPoint());  //try
        }
        return sum;
    }
}
