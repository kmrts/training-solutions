package week07d01;

public class MathAlgorithms {
    //Ebben az osztályban legyen egy isPrime(int x) metódus ami a paraméterül kapott számról eldönti, hogy prím-e vagy sem
    // és ennek megfelelően true vagy false értékkel tér vissza.
    // Aki már tart ott és tudja mit jelent a static az nyugodtan implementálhatja a metódust statikus metódusként.
    // Az egyszerűség kedvért a prímeket most csak a pozitív egész számok körében értelmezzük, így bónuszként rá lehet ellenőrizni,
    // hogy x>0  és ha nem akkor kivételt dobni.
    // Prímeknek tekintjük azokat számokat melyek csak egyel és önmagukkal oszthatók, tehát a 2,3,5,7,11,13 stb. Teszt!!
    public static boolean isPrime(int x){  // - static
        if(x<=0){
            throw new IllegalArgumentException("x must be positive");
        }
        if(x==2){
            return true;
        }
        if(x%2==0){
            return false;
        }
        for(int i= (x-1)/2; i>3; i--){
            if(x%i==0){
                System.out.println("osztó: "+ i);
                return false;
            }
        }
        return true;
//        while()

    }
}
