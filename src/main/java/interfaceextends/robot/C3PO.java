package interfaceextends.robot;

import week03.Position;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot{
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
    //Mivel C3PO nem tud sietni, esetében a moveTo() és fastMoveTo() metódusok ugyanúgy működnek.
    // Célszerű egy privát metódust létrehozni (pl. void walkTo(Point position)),
    // amely beállítja a robot új pozícióját és be is jegyzi ezt a path-ba.
    private Point position;
    private int angle;
    private List<Point> path= new ArrayList<>();

    public C3PO(Point position) {
        this.position = position;
//        this.angle = angle;
//        this.path.add(position);
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    private void walkTo(Point position){
        this.position= position;//new Point(this.position.getX()+ position.getX(), this.position.getY()+ position.getY(), this.position.getZ());
        path.add(this.position);
    }

    @Override
    public void moveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle+= angle;


    }

    @Override
    public List<Point> getPath() {
        return path;
    }
}
