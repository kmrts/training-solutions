package isahasa.htmlmarchaller;

public interface TextSource {
    //Feladat egy html objektum forrássá alakítása osztályokkal. Származtatással a sima szövegből több szöveg
    // is specializálódik vastag, dőlt, aláhúzott. Megnézzük öröklődéssel,
    // majd utána tartalmazással (dekorátor minta használatával)
    //
    //Deklarálj egy TextSource interfészt az isahasa csomagban, melyben csak egy metódus van: String getPlainText().
    //

    String getPlainText();
}
