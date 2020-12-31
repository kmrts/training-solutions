package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    //A katalógus tartalmazza a katalógus elemek listáját
    // és ebben az osztályban lehet különböző lekérdezéseket végrehajtani. Le lehet kérdezni:
    //
    //    Az audio illetve nyomtatott jellemzőkkel rendelkező elemeket (getAudioLibraryItems(), getPrintedLibraryItems())
    //    Az összoldalszámot a nyomtatottaknál (getAllPageNumber())
    //    Az összhosszt az audio típusúaknál (getFullLength())
    //    Az átlag oldalszámot egy bizonyos oldalszám felett (averagePageNumberOver())
    //    Keresni lehet egy SearchCriteria alapján (lásd lejjebb) (findByCriteria())
    static List<CatalogItem> catalogItems= new ArrayList<>();  //static a private helyett: testben catalog.catalogItem

    public void addItem(CatalogItem item){
        catalogItems.add(item);
    }
    public double averagePageNumberOver(int pageNumber){
        if(pageNumber <=0){
            throw new IllegalArgumentException("Page number must be positive");
        }
        int counter= 0;
        int sumPage= 0;
        for(CatalogItem ci: catalogItems){
            int actualNofP= ci.numberOfPagesAtOneItem();
            if(actualNofP>pageNumber){
                sumPage+= actualNofP;
                counter++;
            }
        }
        if(counter==0){
            throw new IllegalArgumentException("No page");
        }
        return (double)sumPage/ counter;
    }
    public void deleteItemByRegistrationNumber(String regNum){
        for(CatalogItem ci: catalogItems){
            if(ci.getRegistrationNumber()== regNum){
                catalogItems.remove(ci);
                break;
            }
        }
    }
    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria){ /////
        List<CatalogItem> foundItems= new ArrayList<>();
        for(CatalogItem ci: catalogItems){
            boolean toAdd= false;
            if(searchCriteria.hasTitle()){
                for(String title: ci.getTitles()){
                    if(title==searchCriteria.getTitle()){
                        toAdd= true;
                        break;
                    }
                }
            }
            if(searchCriteria.hasContributor()){
                for(String contrib: ci.getContributors()){
                    if(contrib==searchCriteria.getContributor()){
                        toAdd= true;
                        break;
                    }
                }
            }
            if(toAdd){
                foundItems.add(ci);
            }
        }
        return foundItems;
    }
    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems= new ArrayList<>();
        for(CatalogItem ci: catalogItems){
            if(ci.hasAudioFeature()){
                audioLibraryItems.add(ci);
            }
        }
        return audioLibraryItems;

    }
    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibItems= new ArrayList<>();
        for(CatalogItem ci: catalogItems){
            if(ci.hasPrintedFeature()){
                printedLibItems.add(ci);
            }
        }
        return printedLibItems;
    }
    public int getAllPageNumber() {
        int sumPages= 0;
        for(CatalogItem ci: catalogItems){
            if(ci.hasPrintedFeature()){
                sumPages+= ci.numberOfPagesAtOneItem();
            }
        }
        return sumPages;

    }
    public int getFullLength() {
        int sumLength= 0;
        for(CatalogItem ci: catalogItems){
            if(ci.hasAudioFeature()){
                sumLength+= ci.fullLengthAtOneItem();
            }
        }
        return sumLength;

    }
}
