package interfaceextends.robot;

import java.util.List;

public interface MoveableRobot {
    //https://github.com/Training360/strukturavalto-java-public/tree/master/solutions/interfaceextends/src/main/java/interfaceextends/robot
    //Egy játék során robotokat fogunk mozgatni.
    // Alapvetően kétféle mozgást kell megvalósítani, gyaloglást és repülést. A szükséges alapműveleteket, mint funkciókat interfészekben definiáljuk.
    // Az egyes konkrét robotok ezeket implementálják, ennek megfelelően fognak majd mozogni.
    //
    //Az interfészek nem függetlenek egymástól, a MoveableRobot interfész leszármazottja a repülést megvalósító (esetünkben a felemelkedés funkciót leíró)
    // FlyableRobot interfész. A robotok mozgását a koordinátákat tartalmazó Point osztály objektumai segítségével lehet követni.
    //
    //MoveableRobot interfész:
    //
    //definiált metódusok:
    //
    //void moveTo(Point position);
    //void fastMoveTo(Point position);
    //void rotate(int angle);
    //List<Point> getPath();
    //A getPath() metódus azoknak a pontoknak a listáját adja vissza, amelyeket a robot mozgása során érintett
    // (a konkrét mozgató utasítások minden esetben bejegyzik a célként kapott Point objektumot).
    //
    void moveTo(Point position);
    void fastMoveTo(Point position);
    void rotate(int angle);
    List<Point> getPath();





    //FlyableRobot extends MoveableRobot interfész:
    //
    //definiált metódus:
    //
    //void liftTo(long altitude);

    //Point osztály final long x, long y és long z attribútumokkal. Csak FlyableRobot esetében kap a z attribútum nullától különböző értéket,
    // a MoveableRobot síkban mozog.
    //
    //publikus metódus:
    //
    //public Point(long x, long y, long z)
    //Két robotot fogunk létrehozni, az egyik csak síkban mozog (C3PO), a másik repülni is tud (AstroBoy).
    //
    //C3PO implements MovableRobot osztály Point position, int angle és List<Point> path attribútumokkal.
    //
    //publikus metódusok:
    //
    //public C3PO(Point position)
    //public void moveTo(Point position)
    //public void fastMoveTo(Point position)
    //public void rotate(int angle)
    //Tipp
    //Mivel C3PO nem tud sietni, esetében a moveTo() és fastMoveTo() metódusok ugyanúgy működnek. Célszerű egy privát metódust létrehozni (pl. void walkTo(Point position)), amely beállítja a robot új pozícióját és be is jegyzi ezt a path-ba.
    //
    //AstroBoy implements FlyableRobot osztály Point position, int angle és List<Point> path attribútumokkal, valamint long ALTITUDE = 5 konstans értékkel;
    //
    //publikus metódusok:
    //
    //public AstroBoy(Point position)
    //public void walkTo(Point position)
    //public void flyTo(Point position)
    //public void liftTo(long altitude)
    //public void moveTo(Point position) // delegálja a funkciót
    //public void fastMoveTo(Point position) //komplex mozgás, felemelkedik, elrepül a célpont fölé, és leereszkedik
    //public void rotate(int angle)
    //Mindegyik mozgás bejegyzi, hogy milyen koordináták mentén történt.
}
