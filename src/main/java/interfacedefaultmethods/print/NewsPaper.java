package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable{
    // A NewsPaper osztály az oldalak tartalmát egy List<String> attribútumban tartsa nyilván.

    private List<String> content= new ArrayList<>();

//    public NewsPaper(List<String> content) {
//        this.content = content;
//    }

    public List<String> getContent() {
        return content;
    }

    @Override
    public int getLength() {
        return content.size();
    }

    @Override
    public String getPage(int page) {
        return content.get(page);
    }

    public void addPage(String addStr){
        content.add(addStr);
    }

//    @Override
//    public String getColor() {
//        return null;
//    }
}
