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

        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;

    }

    public Polynomial(String[] coefficientStrs) {

        if (coefficientStrs == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        try {
            this.coefficients = new double[coefficientStrs.length]; //
            for (int i = 0; i < coefficientStrs.length; i++) {
                this.coefficients[i] = Double.parseDouble(coefficientStrs[i]); //Integer.parseInt(coefficientStrs[i])
            }
        } catch (NumberFormatException iae) { //IllegalArgumentException iae //ex
            throw new IllegalArgumentException("Illegal coefficients, not a number", iae);
        }


    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x) {
        double sum=0;
        double sub=0;

            for(int i=0; i< coefficients.length; i++){
                sub= coefficients[i];
                for(int j=0; j<coefficients.length-(i+1); j++ ){
                    sub *= x;
                }
                sum+= sub;
            }
        return sum;

    }
}
