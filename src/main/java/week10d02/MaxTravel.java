package week10d02;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class MaxTravel {
    /*
    Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni.
    A 12,12,0,3,4,4 sorozat tehát azt jelenti, hogy a 12-es buszmegállóban 2-en, a 0-ásban 1 ember, 3-asban egy ember,
    4-esben 2 ember akar felszállni.
    A MaxTravel osztály getMaxIndex() metódusa adja vissza, hogy hanyas megállóban szeretnének a legtöbben felszállni.
    Maximum 30 megálló lehet.
     */
    public int getMaxIndex(List<Integer> stationList){
        if(stationList==null){
            throw new IllegalArgumentException("can not be null");
        }
        int maxStNum= Collections.max(stationList);
        if(maxStNum>29){
            throw new IllegalArgumentException("station numbers must be 0- 29");
        }
        int[] stnArray= new int[maxStNum+1]; //0-s is van
        for(int station: stationList){
            stnArray[station]++;
        }
//        System.out.println(stnArray.toString());
        int max=0;
        int maxSt=0;

        for(int i=0; i<stnArray.length; i++){
//            System.out.print(stnArray[i]+" ");
            if(stnArray[i] > max){  //előbb találtat, azaz legkisebb sorszámút adja, >= eset a legnbb sorsz-t
                max= stnArray[i];
                maxSt= i;
            }
        }
//        System.out.println(", "+max);
        return maxSt;

    }
    public List<Integer> getMaxIndexList(List<Integer> stationList){
        if(stationList==null){
            throw new IllegalArgumentException("can not be null");
        }
        int maxStNum= Collections.max(stationList);
        if(maxStNum>29){
            throw new IllegalArgumentException("station numbers must be 0- 30");
        }
        int[] stnArray= new int[maxStNum+1]; //0-s is van
        for(int station: stationList){
            stnArray[station]++;
        }
        int max=0;
        List<Integer> listMaxSt= new ArrayList<>();

        for(int i=0; i<stnArray.length; i++){
            if(stnArray[i]== max){
                listMaxSt.add(i);
            }
            if(stnArray[i] > max){
                max= stnArray[i];
                listMaxSt.clear();
                listMaxSt.add(i);
            }
        }
        System.out.println(listMaxSt);
        return listMaxSt;

    }
}
