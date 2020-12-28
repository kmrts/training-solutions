package interfaceextends.robot;

public class Point {

    // Csak FlyableRobot esetében kap a z attribútum nullától különböző értéket,
    // a MoveableRobot síkban mozog.
    //
    //publikus metódus:
    //
    //public Point(long x, long y, long z)

    private final long x;
    private final long y;
    private final long z;

    public Point(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
//    public Point(long x, long y) {
//        this.x = x;
//        this.y = y;
//        this.z = 0;
//    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

}
