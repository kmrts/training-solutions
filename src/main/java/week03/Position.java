package week03;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    public static void main(String[] args) {
        List<Position> pList= new ArrayList<>();
        pList.add(new Position("boss", 250_000) );
        pList.add(new Position("kisfőnök", 170_000 ) );
        pList.add(new Position("alkalmazott", 100_000) );


//        Position p= new Position();
        for (Position pos: pList) {
            if(pos.getBonus()> 150000){
                System.out.println(pos);
            }
        }
    }
}
