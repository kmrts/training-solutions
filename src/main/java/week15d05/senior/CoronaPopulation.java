package week15d05.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CoronaPopulation {
    /*
    Senior feladat
Letölthetőek a COVID adatok a
https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv
címről.
Összegezd országonként az esetszámokat, és add vissza azt a három
országot, ahol az összes esetszám populációra arányosítva a legnagyobb.
     */

    //Map, orsz, lista int v double
    //obj orsz, szum, db

    public Map<String, CountryCase> countries = new TreeMap<>();

    public Map<String, CountryCase> getCountries() {
        return new TreeMap<>(countries);
    }

    public void readData(Path path) {

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
//
                addLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("cannot read file", ioe);
        }
    }

    private void addLine(String line) {
        line = arrangeLine(line);
        String[] spl = line.split(":");
        String country = spl[4];
//        cases= Math.sqrt(-1);

        if (!spl[2].isEmpty() && !spl[7].isEmpty()) {
//            try {
//                int cases = Integer.parseInt(spl[2]);
//                int popul = Integer.parseInt(spl[7]);
//            } catch (NumberFormatException e) {
//                throw new IllegalArgumentException("illegal arg", e);
//            }
            int cases = Integer.parseInt(spl[2]);
            int popul = Integer.parseInt(spl[7]);

            if (countries.containsKey(country)) {
                CountryCase temp = countries.get(country);
                temp.setSumCases(temp.getSumCases() + cases);
                temp.setCounter(temp.getCounter() + 1);
                countries.put(country, temp);
            } else {
                countries.put(country, new CountryCase(country, popul, cases, 1));
            }
        }


    }

    private String arrangeLine(String line) {
//        StringBuilder sb= new StringBuilder(line);
//        sb.replace(", ", ";,");
        line = line.replace(", ", ";;");
        line = line.replace(",", ":");
        line = line.replace(";;", ", ");
        return line;
    }
    public String threeMax(){
        List<CasePerCapita> perCapitas= new ArrayList<>();
        for(Map.Entry<String, CountryCase> entry: countries.entrySet()){

            double temp= (double) entry.getValue().getSumCases()*1000 /entry.getValue().getPopulation() ;
            perCapitas.add(new CasePerCapita(entry.getValue().getCountry(), temp));
        }
//        System.out.println(perCapitas);
        Collections.sort(perCapitas, new Comparator<CasePerCapita>() {
            @Override
            public int compare(CasePerCapita o1, CasePerCapita o2) {
                return (int)o2.getPerCapita() - (int)o1.getPerCapita();
            }
        });
        System.out.println(perCapitas);
        for(int i=0; i<3; i++){
            System.out.println(perCapitas.get(i).getCountry());
        }
        return perCapitas.get(0).getCountry();
    }

    public static void main(String[] args) {
        CoronaPopulation cp = new CoronaPopulation();
        cp.readData(Path.of("data.csv"));
        System.out.println(cp.getCountries());
        cp.threeMax();
    }
}
