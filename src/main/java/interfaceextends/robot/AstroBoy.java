package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot{
    //AstroBoy implements FlyableRobot osztály Point position, int angle és List<Point> path attribútumokkal,
    // valamint long ALTITUDE = 5 konstans értékkel;
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
    private Point position;
    private int angle;
    private List<Point> path =new ArrayList<>();  //
    static final long ALTITUDE = 5;  //not private

    public AstroBoy(Point position) {
        this.position = position;
//        path.add(this.position);
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void liftTo(long altitude) {
        setPosition(new Point(position.getX(), position.getY(), position.getZ()+ altitude) );
        path.add(position);

    }

    @Override
    public void moveTo(Point position) {
        walkTo(position); //new Point(this.position.getX()+ position.getX(), this.position.getY()+ position.getY(),
//                this.position.getZ()));
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        flyTo(position);
        liftTo(ALTITUDE* -1);

    }

    @Override
    public void rotate(int angle) {
        this.angle+= angle;
    }
    public void walkTo(Point position){
        this.position= position;
        path.add(this.position);
    }
    public void flyTo(Point position){
        setPosition(new Point(this.position.getX()+ position.getX(), this.position.getY()+ position.getY(),
                this.position.getZ()+ position.getZ()));
        path.add(this.position);
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public long getAltitude() {
        return position.getZ();
    }
}
