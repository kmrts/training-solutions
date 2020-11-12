package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> translations= new ArrayList<>();//

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
//        this.translations = translations;
        addTranslations(translations); //
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }
    public void addTranslations(List<String> newTrans){
        for(String item: newTrans){
            if(!translations.contains(item)) {
                translations.add(item);
        }                }
    }
}
