package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems= new ArrayList<>();//

    public void addItem(String word, List<String> wTransList){
        if(!dictionaryItems.contains(word)){
            DictionaryItem di = new DictionaryItem(word, wTransList);
            dictionaryItems.add(di);
            //vagy: dictionaryItems.add(new DictionaryItem(word, wTransList));
        }else{
            for(DictionaryItem dItem: dictionaryItems){
                if(dItem.getWord().equals(word)){
                    dItem.addTranslations(wTransList);
                }
            }

        }
    }
    public List<String> findTranslations(String word){
        for(DictionaryItem dItem: dictionaryItems) {
            if (dItem.getWord().equals(word)) {
                return dItem.getTranslations();
            }
        }
        return new ArrayList<>();
    }
}
