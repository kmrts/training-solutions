package iostringwriter.longwords;

import java.io.IOException;
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
    public String listToStringWriter(Writer w, List<String> aList) {
        try (StringWriter swr = new StringWriter()) {
            for (String item : aList) {
                swr.write(item);
                swr.write(" " + item.length() + "\n");
            }
//            System.out.println(swr.toString());
            return swr.toString();
        } catch (IOException ex) {
            throw new IllegalStateException("cannot write", ex);
        }

    }

    public String writeWithStringWriter(List<String> bList) {
        try (StringWriter swr = new StringWriter()) {
            return listToStringWriter(swr, bList);
        } catch (IOException e) {
            throw new IllegalStateException("cannot write", e);
        }

    }
}
