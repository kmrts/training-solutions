package exceptions.polinom;

public class Polynomial {
    /*
    Készítsen egy Polinom osztályt, amelynek segítségével tetszőleges polynomial értékét ki tudjuk számolni adott x értéknél.
    A polinomot az együtthatóinak a tömbje írja le.
    A polinomot lehessen inicializálni az együtthatók tömbjével (double[]), de lehessen inicializálni String[] -el is (pl. beolvasott értékek).
    Az osztálynak legyen egy public double evaluate(double x) metódusa, amely adott x értéknél visszaadja a polynomial értékét.
    Valamint legyen getter az együtthatók tömbjére. A double[] paraméterű konstruktor dobjon NullPointerException kivételt, ha a paraméter null.
    A String[] paraméterű konstruktor dobjon NullPointerException kivételt, ha a paraméter null,
    valamint dobjon IllegalArgumentException-t ha az egyes String-ek nem alakíthatók double számmá.
     */
    double[] coefficients;

    public Polynomial(double[] coefficients) {
//        try{
//            this.coefficients = coefficients;
//        }
//        catch (NullPointerException npe){
//            throw new NullPointerException("coefficients is null");
//        }
        if(coefficients==null){
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;

    }
    public Polynomial(String... coefficients) {
        try{
            int i= 0;
            for(String s: coefficients){
                this.coefficients[i] = Integer.parseInt(s);
                i++;
            }
        }catch (IllegalArgumentException iae){
            throw new IllegalArgumentException("Illegal argument", iae);
        }catch (NullPointerException npe){
            throw npe;
        }

    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public String evaluate(double x){
//        for()
        return null;

    }
}
