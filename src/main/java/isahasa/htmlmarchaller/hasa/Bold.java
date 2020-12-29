package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Bold extends TextDecorator{
    //Bold osztály (ami egy konkrét dekorátor a hasa csomagban) a TextDecorator osztályból származik.
    //
    //    definiál egy konstruktort, amely megkap egy TextSource referenciát, amire beállítja az örökölt textSource attribútumot.
    //    implementálja az őstől kapott getPlainText metódust úgy,
    //    hogy a tartalmazott textSource referenciája meghívja a getPlainText metódust,
    //    és az értéket közrezárja a <b> és </b> tag-ek közé. (Ez még nagyon hasonló a származás megoldásához.
    //    Különbség az, hogy ott a super-en hívtuk meg a getPlainText metódusát, itt pedig az attribútumon.)


    public Bold(TextSource textSource) {
        super(textSource);
    }


    @Override
    public String getPlainText() {
        return "<b>"+ getTextSource().getPlainText()+ "</b>";
    }

}
