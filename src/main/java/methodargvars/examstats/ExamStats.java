package methodargvars.examstats;

public class ExamStats {

    //képes változó számú vizsgaeredmény (pontokban megadva) esetén "statisztikát" készíteni.
    // Ehhez az objektum adott vizsga esetén megkapja a max pontszámot konstruktorban, majd az egyik metódusában a küszöbérték
    // (százalék) valamint a vizsgaeredmények (pontok) felsorolásával ki tudja számolni az adott küszöbérték feleltti eredmények számát.
    // Egy másik metódusban az alsó küszöbérték (százalékban) megadása és a vizsgaeredmény felsorolás megadásával meg tudja mondani, bukott-e valaki a vizsgán.
    //
    //Publikus metódusok:
    //
    // public ExamStats(int maxPoints)
    // public int getNumberOfTopGrades(int limitInPercent, int... results)
    // public boolean hasAnyFailed(int limitInPercent, int... results)

    //Ha a felsorolást nem adja meg a felhasználó (kihagyja a paramétert), a metódusnál nem mutat hibát az IDE.
    // Vararg esetén ugyanis ilyenkor automatikusan üres tömb lesz a paraméter. Ebben az esetben viszont
    // IllegalArgumentException-t várunk,
    // a megfelelő tájékoztató szöveggel.

    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results){
//        if (results==null){
//            throw new IllegalArgumentException("Number of results must not be empty!");
//        }
//        if (results.length== 0){
//            throw new IllegalArgumentException("Number of results must not be empty!");
        //ford sorr nem jó a teszt
        if (results==null || results.length== 0){  //results.length== 0 || results==null
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        int num= 0;
        for(int r: results){
            if(r > maxPoints* limitInPercent/100){
                num++;
            }
        }
        return num;
    }
    public boolean hasAnyFailed(int limitInPercent, int... results){
        if (results.length== 0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        boolean failed= false;
        for(int r: results){
            if(r < maxPoints* limitInPercent/100){
                failed= true;
            }
        }
        return failed;
    }
}
