package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public abstract class TextDecorator implements TextSource {

    //implementálja a konkrét dekorátoroknak a tartalmazás kapcsolatot.
    //
    //    A TextSource interfészt implementálja. (az előírt metódust nem definiálja felül,
    //    ezért is lesz absztrakt)
    //    egy védett attribútuma van: TextSource textSource
    private TextSource textSource;

    public TextDecorator(TextSource textSource) { //
        this.textSource = textSource;
    }

    public TextSource getTextSource() { //
        return textSource;
    }
}
