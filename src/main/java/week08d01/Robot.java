package week08d01;

public class Robot {
    //A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert,
    // ahol a robot az origóban van. A robot négy irányba képes mozogni fel, le, balra és jobbra.
    // A week08d01.Robot osztályban írj egy move() metódust ami egy karaktersorozatot vár.
    // pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb.
    // A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója.
    // A feladat szabadon bővíthető osztályokkal és metódusokkal. Bónusz kiegészítés,
    // hogyha más karaktert is tartalmaz a paraméter String nem csak a FLBJ valamelyikét, akkor dobjunk IllegalArgumentExceptiont!
    private Position pos;

    public Robot() {
        this.pos = new Position(0, 0);
    }

    public Position getPos() {
        return pos;
    }

    @Override
    public String toString() {
        return "pos= " + pos;
    }

    public Position move(String moves){
        for(int i= 0; i< moves.length(); i++){
            switch (moves.toUpperCase().charAt(i)){
                case 'F':
                    pos.setY(pos.getY()+1);
                    break;
                case 'L':
                    pos.setY(pos.getY()-1);
                    break;
                case 'B':
                    pos.setX(pos.getX()-1);
                    break;
                case 'J':
                    pos.setX(pos.getX()+1);
                    break;
                default:
                    throw new IllegalArgumentException("Only F,L,B,J !");

            }
        }
        return pos;
    }
}
