package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{
    //Ez az osztály jellemez egy katalóguselemet, ha az audio tulajdonságokkal rendelkezik.
    // Ilyen a zenei album és hangoskönyv.
    // Minden audio elemnek van címe, hossza, előadói, illetve szerzői.
    // Implementálja a Feature interface-t. A szerzők megadása nem kötelező (két konstruktor szükséges, overload).
    // A getContributors() metódus a szerzők és előadók közös listájával tér vissza.
    private List<String> composer= new ArrayList<>();//
    private int length;
    private List<String> performers= new ArrayList<>();
    private String title;


    public AudioFeatures(String title, int length, List<String> performers) {
        if(title.isBlank()){
            throw new IllegalArgumentException("Title is blank.");
        }
        this.title = title;
        if(length<= 0){
            throw new IllegalArgumentException("Lenght is below zero");
        }
        this.length = length;
        if(performers.isEmpty()){
            throw new IllegalArgumentException("Performers is empty.");
        }
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {

        this(title, length, performers);
        this.composer = composer;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors= new ArrayList<>();
        for(String item: composer){
            contributors.add(item);
        }
        for(String item: performers){
            contributors.add(item);
        }
        return contributors;
    }
}
