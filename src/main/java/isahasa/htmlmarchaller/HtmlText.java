package isahasa.htmlmarchaller;

public class HtmlText implements TextSource{
    ////Hozz létre egy HtmlText osztályt az isahasa csomagban, ami implementálja a TextSource interfészt.
    //    // Egy plainText attribútumban tárolja a kívánt szöveget, melyet a konstruktorban kap meg.
    //    //
    //    //    a getPlainText() ebben az esetben csak visszaadja a tárolt szöveget.
    //    //
    //
    private String plainText;

    public HtmlText(String plainText) {
        this.plainText = plainText;
    }

    @Override
    public String getPlainText() {
        return plainText;
    }
}
