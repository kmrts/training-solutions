package methodpass.troopers;

public class Trooper {

    private String name;
    private Position position;

    public Trooper(String name) {
        if(isEmpty(name)){
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
        this.position= new Position(0,0);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
    public void changePosition(Position target){
        if(target== null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        position= target;
    }
    public double distanceFrom(Position target) {
        return Math.sqrt(Math.pow(target.getPosX() - position.getPosX(), 2) + Math.pow(target.getPosY() - position.getPosY(), 2));
    }

    public boolean isEmpty(String st){
        return st.equals("") ? true : false;
    }
}

