package interfaceextends.robot;

import java.util.List;

public interface MoveableRobot {
    //https://github.com/Training360/strukturavalto-java-public/tree/master/solutions/interfaceextends/src/main/java/interfaceextends/robot
    //Egy játék során robotokat fogunk mozgatni.
    // Alapvetően kétféle mozgást kell megvalósítani, gyaloglást és repülést.
    // A szükséges alapműveleteket, mint funkciókat interfészekben definiáljuk.
    // Az egyes konkrét robotok ezeket implementálják, ennek megfelelően fognak majd mozogni.
    //
    //Az interfészek nem függetlenek egymástól, a MoveableRobot interfész leszármazottja
    // a repülést megvalósító (esetünkben a felemelkedés funkciót leíró)
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


}
