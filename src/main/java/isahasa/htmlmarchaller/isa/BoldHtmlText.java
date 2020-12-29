package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class BoldHtmlText extends HtmlText {
    //A BoldHtmlText a vastagon szedett szöveget megvalósító osztály az isa csomagban van, és a HtmlText-ből származik.
    //
    //    a konstruktorban megkapott szöveget a super-nek adjuk át, így inicializáljuk.
    //    a getPlainText <b> és </b> közzé fogja az ősben definiált getPlainText eredményét.
    //
    //Hasonlóan kell megvalósítani a ItalicHtmlText osztályt, de ez a <i> és </i> tageket használja.
    // A UnderlinedHtmlText osztály az <u> és </u> tageket használja. A ItalicAndBoldHtmlText a <i><b> és </b></i> tagek kombinációját használja.
    // A UnderlinedAndItalicAndBoldHtmlText a <u><i><b> és </b></i></u> tagek kombinációját használja.
    //
    //Vegyük észre, hogy minden variációra külön osztály kell (pl.: vastagbetűs és aláhúzott és dőlt).


    public BoldHtmlText(String plainText) {
        super(plainText);
    }

    @Override
    public String getPlainText() {
        return "<b>"+ super.getPlainText() +"</b>";
    }
}
