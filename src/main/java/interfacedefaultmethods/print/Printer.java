package interfacedefaultmethods.print;

import java.util.List;

public class Printer {

    //A Printer osztály print() metódusa menjen végig a nyomtatható anyag oldalain,
    // és fűzze össze egy String-be, sortörésekkel elválasztva (használj StringBuilder-t).
    // Amennyiben az oldal színes (azaz nem fekete-fehér), az oldal tartalma elé
    // írja ki vezérlőkarakterekként az oldal színét.
    // Azaz ha az oldal piros (#FF0000), és az oldal tartalma Content, akkor úgy fűzze hozzá a String-hez,
    // hogy [#FF0000]Content.
    public String print(NewsPaper printable) {
        StringBuilder sb = new StringBuilder();
        for (String s : printable.getContent()) {
            sb.append(s);
            sb.append(String.valueOf("\n"));
        }
        return sb.toString();
    }

    public String print(StoryBook printable) {
        StringBuilder sb = new StringBuilder();
//        for (Printable p : printable) {
//            if (!p.getColor(printables.indexOf(p)).equals("#000000")) {
//                sb.append("[" + p.getColor(printables.indexOf(p)) + "]");
//            }
//            sb.append(p.getPage(printables.indexOf(p)));
//        }
        for(int i=0; i<printable.getLength(); i++){
            if(!printable.getColor(i).equals("#000000")){
                sb.append("[" +  printable.getColor(i) + "]");
            }
            sb.append(printable.getPage(i));
            sb.append(String.valueOf("\n"));
        }
        return sb.toString();
    }
}
