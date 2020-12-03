package methodpass.troopers;

public class Position {

    //Két pont távolságát síkban az alábbi képlettel lehet kiszámítani: gyök x1-x2 ^2 + y...
    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
    public double distanceFrom(Position position){
        return Math.sqrt( Math.pow(position.getPosX() - posX, 2) + Math.pow(position.getPosY() - posY, 2) );
    }
}
