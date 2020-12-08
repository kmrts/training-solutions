package week07d02;

public class DigitSum {
    //benne sumOfDigits(int x) metóódus mely visszaadja a paraméterül kapott szám számjegyeinek összegét!
    // pl.: 123 esetén a visszatérési érték 6. (Bocsi, hogy megint matekos holnap már nem az lesz ígérem

    public int sumOfDigits(int x){
        int number= x;
        int digit= 0;
        int sumdigit= 0;
        while(number != 0){
            digit= number%10;
            sumdigit+= digit;
            number= (number - digit)/10;
        }
        return sumdigit;
    }
}
