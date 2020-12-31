package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{
    //Ez az osztály jellemez egy katalóguselemet, ha az nyomtatott tulajdonságokkal rendelkezik.
    // A nyomtatott jellemzők a cím, az oldalszám, illetve a szerzők.
    // Szintén a Feature-t implementálja. A getContributors() itt a szerzőket adja vissza listaként.


    private String title;
    private int numberOfPages;
    private List<String> authors;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if(title.isBlank()){
            throw new IllegalArgumentException("Empty title");
        }
        this.title = title;
        if(numberOfPages<=0){
            throw new IllegalArgumentException("Invalid number of pages.");
        }
        this.numberOfPages = numberOfPages;
        if(authors== null || authors.isEmpty()){    //isEmpty sem hívható ha null
            throw new IllegalArgumentException("Authors is empty.");
        }
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }
}
