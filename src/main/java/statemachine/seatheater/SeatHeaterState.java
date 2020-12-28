package statemachine.seatheater;

public enum SeatHeaterState {
    //Egy gombbal lehet állítani az autóban az ülésfűtést. Alapállapotban ki van kapcsolva.
    // Ha ekkor megnyomjuk, akkor maximális (3-as) fokozatra kapcsol a fűtés,
    // ha mégegyszer megnyomjuk, akkor 2-es fokozatra áll, ha mégegyszer, akkor 1-esre áll,
    // és ha mégegyszer, akkor kikapcsol. Szimuláljuk a gomb működését, hogyan vált a 4 állapot között.
    OFF {
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    },
    ONE {
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    },
    TWO{
        SeatHeaterState next(){
            return SeatHeaterState.ONE;
        }
    },
    THREE{
        SeatHeaterState next(){
            return SeatHeaterState.TWO;
        }
    };

    abstract SeatHeaterState next();  //kell az abs.
}
