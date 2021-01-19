package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {
    /*
    Az első feladatban hosszú szavakat kell kezelned StringWriter segítségével.
    Írj egy metódust, ami egy Writer-t és egy listát kap paraméterül, és minden lista beli elem után írja a szó hosszát!
    Majd írj egy metódust, ami csak egy listát vár, és az előzőleg megírt metódust használja
    a paraéterül kapott listával és egy példányosított StringWriter-rel!
     */
    public void listToStringWriter(Writer w, List<String> aList) {
        PrintWriter pw= new PrintWriter(w);    //
        for(String str: aList){
            pw.print(str +" ");
            pw.println(str.length());
        }

    }

    public String writeWithStringWriter(List<String> bList) {
        try (StringWriter swr = new StringWriter()) {
            listToStringWriter(swr, bList);
//            System.out.println(swr.toString());
            return swr.toString();
        } catch (IOException e) {
            throw new IllegalStateException("cannot write", e);
        }

    }
}
