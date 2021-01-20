package week12d02;

public class Site {
    /*
    Készítsd el a Site (telek) nevű osztályt. Egy telek jellemzői, páros vagy páratlan oldalon található, (0 = páros oldal 1 = páratlan oldal),
    a telek hossza méterben. Illetve egy Fence enum, ami a kerítés állapotát írja le.
    A kerités állapota lehet, PERFECT, NEED_UPGRADE, NO_FENCE. (konstruktor, getterek)

     */
    private boolean ifOdd;
    private double length;
    private Fence state;

    public Site(boolean ifOdd, double length, Fence state) {
        this.ifOdd = ifOdd;
        this.length = length;
        this.state = state;
    }

    public boolean isIfOdd() {
        return ifOdd;
    }

    public double getLength() {
        return length;
    }

    public Fence getState() {
        return state;
    }
}
