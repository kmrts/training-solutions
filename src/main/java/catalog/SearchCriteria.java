package catalog;

import javax.xml.validation.Validator;

public class SearchCriteria {
    //Egy immutable osztály melynek attribútumai egy cím és egy szerző.
    // Az osztályt úgy kell megvalósítani, hogy akár cím, akár szerző alapján, sőt mindkettő alapján lehessen
    // keresni a katalógusban (statikus metódusokkal lehet létrehozni).
    private String contributor = "";
    private String title = ""; //

    private SearchCriteria(String title, String contributor) {
//        if(contributor!=null){
//            this.contributor = contributor;
//        }
//        if(title!=null){
//            this.title = title;
//        }
        this.title = title;
        this.contributor = contributor;

    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {  // title == null
            throw new IllegalArgumentException("Invalid tittle");
        }
        return new SearchCriteria(title, "");
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {      // contributor == null
            throw new IllegalArgumentException("Invalid contributor");
        }
        return new SearchCriteria("", contributor);
    }

    static SearchCriteria createByBoth(String title, String contributor) {
        if(Validators.isBlank(title) || Validators.isBlank(contributor)){
            throw new IllegalArgumentException("Invalid argument");
        }
        return new SearchCriteria(title, contributor);
    }


    public boolean hasContributor() {
        return getContributor().isBlank() ? false : true;
    }

    public boolean hasTitle() {
        return getTitle().isEmpty() ? false : true;


    }
}
