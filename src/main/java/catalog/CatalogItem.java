package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {
    //Minden katalógus elemnek van egy jellemzők listája melyek lehetnek akár nyomtatottak vagy audio-k.
    // Továbbá minden katalógus elemnek van ára és egy regisztrációs száma.
    private String registrationNumber;
    private int price;
    private List<Feature> features= new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... features) {///
        this.registrationNumber = registrationNumber;
        this.price = price;
        for(Feature f: features){ ///
            this.features.add(f);
        }

    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int numberOfPagesAtOneItem(){
        int sumPages=0;
        for(Feature fea: features){
            if(fea instanceof PrintedFeatures){
                sumPages+= ((PrintedFeatures) fea).getNumberOfPages();
            }
        }
        return sumPages;
    }
    public int fullLengthAtOneItem(){
        int sumLength=0;
        for(Feature fea: features){
            if(fea instanceof AudioFeatures){
                sumLength+= ((AudioFeatures) fea).getLength();  //
            }
        }
        return sumLength;
    }
    public List<String> getContributors(){
        List<String> contributors= new ArrayList<>();
        for(Feature f: features){
            contributors.addAll(f.getContributors());
        }
        return contributors;
    }
    public List<String> getTitles(){
        List<String> sumTitles= new ArrayList<>();
        for(Feature f: features){
            sumTitles.add(f.getTitle());
        }
        return sumTitles;
    }
    public boolean hasAudioFeature() {
        for(Feature fea: features){
            if(fea instanceof AudioFeatures){
                return true;
            }
        }
        return false;
    }
    public boolean hasPrintedFeature(){
        for(Feature fea: features){
            if(fea instanceof PrintedFeatures){
                return true;
            }
        }
        return false;
    }


}
