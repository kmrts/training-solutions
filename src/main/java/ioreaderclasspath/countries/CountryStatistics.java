package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    // src/main/resources/country.txt

    List<Country> countryList= new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }


    public void readFromFile(String fileName){
        try (BufferedReader brd = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" +fileName)))) { //
            String line;
            while( (line= brd.readLine() )!= null){
                String[] s= line.split(" ");
//                String name= line.substring(0, line.indexOf(' '));
//                int neibs= Integer.parseInt( line.substring(line.indexOf(' ' +1)));
                countryList.add(new Country(s[0], Integer.parseInt(s[1])));
            }

        }catch (IOException ioe){
            throw new IllegalStateException("cannot read", ioe);
        }

    }
    public int numberOFCountries(){
        return countryList.size();
    }
    public Country mostBorderCountries(){
        if(countryList.isEmpty()){
            throw new IllegalArgumentException("countrylist is null");
        }
        int max= countryList.get(0).getBorderCountries();
        String country= countryList.get(0).getName();
        for(Country cou: countryList){
            if(cou.getBorderCountries()>max){
                max= cou.getBorderCountries();
                country= cou.getName();
            }
        }
        return new Country(country, max);
    }
}
