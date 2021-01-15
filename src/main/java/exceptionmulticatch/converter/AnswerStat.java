package exceptionmulticatch.converter;

public class AnswerStat {
    /*
    Majd pedig kell egy AnswerStat osztály, amely az igaz/hamis adatokon számol statisztikát, jelen esetben az igaz értékek százalékos arányát.
    legyen egy convert metódus, amely a binaryStringToBooleanArray metódus hívását csomagolja be.
    Azaz elkapja a konvertálás során előforduló NullPointerException-t vagy IllegalArgumentException-t és logolja a hibát,
    majd tovább dobja becsomagolva egy InvalidBinaryStringException-be, amely egy saját RuntimeException-ból származó kivételosztály.
    Mivel mindkét hibafajtára ugyanazt kell csinálni, használja a multi-catch-et.
    Legyen egy int answerTruePercent(String answers) metódusa, amely a paramétert boolean tömbbé alakítja,
    majd meghatározza és visszaadja az igaz értékek százalékos arányát egészre kerekítve.
    A konstruktor paraméterben kapja meg a BinaryStringConverter-t.
     */
    private BinaryStringConverter bsc;

    public AnswerStat(BinaryStringConverter bsc) {
        this.bsc = bsc;
    }

    public boolean[] convert(String input){
        try{
            return bsc.binaryStringToBooleanArray(input);
        }catch (NullPointerException | IllegalArgumentException ex){
            throw new InvalidBinaryStringException("BinaryString error", ex);
        }
    }
    public int answerTruePercent(String answers){
        boolean[] booleans= convert(answers);
        double trues= 0;
        for(boolean b: booleans){
            if(b){
                trues++;
            }
        }
        return (int)Math.round(trues/ booleans.length *100);
    }
}
