package week12d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Street {
    /*
    Készítsd el a Street neű osztályt, melyben eladott telkek listája található. Kezdetben ez egy üres lista.
Készíts egy sellSite(Site site) metódust, ami egy telek eladását reprezentálja, vagyis hozzádunk egy telket a listához.
Határozd meg az utoljára eladott telek (lista utolsó eleme) házszámát, ha tudjuk, hogy a telkeket a két oldalon egymás után adták el!
(páros oldalon kettőtől, páratlan oldalon 1-től indul a számozás)
pl:
0 10 PERFECT
0 7 NEED_UPGRADE
1 12 NEED_UPGRADE
0 9 PERFECT
0 11 NO_FENCE
1 13 PERFECT
A példában a házszámok rendre: 2,4,1,6,8,3
Készíts statisztikát, ami a kerítés állapota alapján visszaadja, hogy mennyi telket adtak el kerítésfajtánként!
(Egy metódus legyen, a visszatérési értéket ti döntitek el, de abból legyen egyértelmű, hogy melyikből mennyit adtak el.)
     */
    private final List<Site> selledSites= new ArrayList<>();  //sonarLint: final

    public void sellSite(Site site){
        selledSites.add(site);
    }
    public int lastSelledNumber(){
        if(selledSites.isEmpty()){
            throw new IllegalArgumentException("there is no selled site");
        }
        int lastEven= 0;
        int lastOdd= -1;
        for (Site si: selledSites) {
            if(si.isIfOdd()){
                lastOdd+= 2;
            }else{
                lastEven+= 2;
            }
        }
        return selledSites.get(selledSites.size() -1).isIfOdd() ? lastOdd : lastEven;
    }
    public String sellingStats(){
        int[] stats= new int[3];
        for(Site si: selledSites){
            int index= si.getState().ordinal(); //0 , 1, 2
//            System.out.println(index);
            stats[index]++;
        }
        String title= String.format("%s, %s, %s: ", Fence.values()[0], Fence.values()[1], Fence.values()[2]);
        return title+ Arrays.toString(stats);
    }


}
