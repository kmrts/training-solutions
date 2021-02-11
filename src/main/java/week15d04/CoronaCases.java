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
    List<Case> three= new ArrayList<>();

    private String country;

    private final static int ARR_SIZE= 10;

    public CoronaCases(String country) {
        this.country = country;
    }

    public List<Case> getCaseList() {
        return caseList;
    }

    public List<Case> getThree() {
        return three;
    }

    public void readData(Path path){
        try (BufferedReader brd = Files.newBufferedReader(path)) {
            String line= brd.readLine(); //1. sor
            while( (line= brd.readLine()) != null){
                makeAndAddCase(line);
            }

        }catch (IOException e){
            throw new IllegalArgumentException("cannot read file", e);
        }
    }
    private void makeAndAddCase(String line){
        String[] spl= line.split(",");

//        if(spl.length < ARR_SIZE){
//            throw new IllegalArgumentException("Wrong data");
//        }
        if( spl[4].equals(country)){
            caseList.add(new Case(spl[1], Integer.parseInt(spl[2]) ));
        }

    }
    public String sortAndThreeMax(){
        List<Case> sorted= new ArrayList<>(caseList);
        Collections.sort(sorted, new Comparator<Case>() {
            @Override
            public int compare(Case o1, Case o2) {
                return o1.getCaseOfWeek() - o2.getCaseOfWeek();
            }
        });
//        System.out.println("sorted "+ sorted);
//        System.out.println("ered "+ caseList);
        return threeMax(sorted);

    }
    private String threeMax(List<Case> list){
        StringBuilder sb= new StringBuilder(country+ ": a három max eset: ");

        for(int i= 1; i<=3; i++ ){
            Case actual= list.get(list.size()- i);
            three.add(actual);
            sb.append(String.format("a %s héten %d eset, ", actual.getWeek(),
                    actual.getCaseOfWeek()));
        }
        sb.delete(sb.length()-2, sb.length()).append(".\n");
        return sb.toString();
//        return three;
    }

}
