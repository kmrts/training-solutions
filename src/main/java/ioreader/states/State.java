package ioreader.states;

public class State {
    /*
    A stateregister.txt állomány tartalmazza az Amerikai Egyesült Államok államait és azok fővárosait kötőjellel elválasztva.
    Neked ezt a fájlt kell feldolgoznod és egy keresés algoritmust készítened!
    Hozzd létre a State java osztályt melynek két attribútuma az állam neve stateName és a főváros neve capital! (Konstruktor,getterek!)

         */
    private String stateName;
    private String capital;

    public State(String stateName, String capital) {
        this.stateName = stateName;
        this.capital = capital;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCapital() {
        return capital;
    }
}
