package week12d01;

public class GradeRunner {
    /*
    van egy int[] roundGrades(int[] grades) metódus.
    A grades tömb pontszámokat tartalmaz 0 és 100 között.
    A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint:
    Ha a pontszám és az 5 következő többszöröse közötti különbség kisebb, mint 3, akkor kerekítsük fel a számot
    az 5 következő többszörösére.
    Fontos: a 40 pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni.
     Példa: a pontszám 84. 85 - 84 kevesebb mint 3, így felfelé kerekítünk.
     */
    public int[] roundGrades(int[] grades){
        int[] roundedGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int actual= grades[i];

            if(actual >40 && isUp(actual)){
                actual = actual - actual%5 +5; //actual -= actual%5 +5
            }
//            else{
//                actual -= actual%5;
//            }
            roundedGrades[i]= actual;
        }
        return roundedGrades;
    }
    public boolean isUp(int num){
        if((num - num%5 +5) - num <3){  //5- num%5
            return true;
        }
        return false;
    }
}
