package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable {
    // A StoryBook használjon egy ColoredPage immutable osztályt, mely az oldal tartalmát (String)
    // és az oldal színét (String) tartalmazza.
    // A StoryBook egy ilyen listát tartalmazzon, így minden oldalra megmondható, hogy milyen színű.

    private List<ColoredPage> content= new ArrayList<>();

//    public StoryBook(List<ColoredPage> coloredPages) {
//        this.coloredPages = coloredPages;
//    }

    @Override
    public int getLength() {
        return content.size();
    }

    @Override
    public String getPage(int page) {
        return content.get(page).getContent();
    }

    @Override
    public String getColor(int page) {
        return content.get(page).getColor();
    }

    public List<ColoredPage> getContent() {
        return content;
    }

    public void addPage(String cont, String color){
        content.add(new ColoredPage(cont, color));
    }
}
