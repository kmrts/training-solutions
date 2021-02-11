package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CoronaCases {
    /*
    Letölthetőek a koronavírus adatok innen: https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv
    Melyik három héten volt Magyarországon a legtöbb esetszám?
     */
    private List<Case> caseList= new ArrayList<>();

    private final static int ARR_SIZE= 10;

    public List<Case> getCaseList() {
        return caseList;
    }

    public void readData(Path path){
        try (BufferedReader brd = Files.newBufferedReader(path)) {
            String line= brd.readLine(); //1. sor
            while( (line= brd.readLine()) != null){
                makeAndAddCase(line, "Hungary");
            }

        }catch (IOException e){
            throw new IllegalArgumentException("cannot read file", e);
        }
    }
    private void makeAndAddCase(String line, String country){
        String[] spl= line.split(",");

//        if(spl.length < ARR_SIZE){
//            throw new IllegalArgumentException("Wrong data");
//        }
        if( spl[4].equals(country)){
            caseList.add(new Case(spl[1], Integer.parseInt(spl[2]) ));
        }

    }
    public List<Case> sortAndThreeMax(){
        List<Case> sorted= new ArrayList<>(caseList);
        Collections.sort(sorted, new Comparator<Case>() {
            @Override
            public int compare(Case o1, Case o2) {
                return o1.getCasePerWeek() - o2.getCasePerWeek();
            }
        });
//        System.out.println("sorted "+ sorted);
//        System.out.println("ered "+ caseList);
        return threeMax(sorted);

    }
    private List<Case> threeMax(List<Case> list){
        List<Case> three= new ArrayList<>();
        for(int i= 1; i<=3; i++ ){
            three.add(list.get(list.size()- i));
        }
        return three;
    }

}
