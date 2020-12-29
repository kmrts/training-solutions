package isahasa.htmlmarchaller;

public class Client{  //jav
    //Hozz létre egy Channel interfészt, ami csak egy metódust tartalmaz: int writeByte(byte[] bytes)
        //
        //Szükség van még egy kliens osztályra, amely kap egy TextSource-ot és ráírja a csatornára a tartalmát.
        //
        //    A csatornáját egy attribútumban tárolja.
        //    Konstruktorban megkapja a csatorna referenciát, amit eltárol az attribútumban.
        //    definiál egy publikus writeToChannel metódust, ami megkap egy TextSource referenciát.
        //    A paraméter tartalmát lekéri a getPlainText metódussal, amit átalakít byte tömbbé
        //    (String osztálynak van ilyen metódusa), és ezzel hívja a csatorna writeByte metódusát.
    private Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }



    public int writeToChannel(TextSource ref){

        return channel.writeByte(ref.getPlainText().getBytes());  ///

    }
}
