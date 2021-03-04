package exam03retake02;

public class Todo {
    /*
    Írj egy tennivaló osztályt ( Todo ), melynek attribútumai: text, state és priority, rendre String, State és int típusú .
                                 A State egy saját enum COMPLETED és NON_COMPLETED értékekkel.
                                 A prioritás 1 és 5 közötti egész szám. Ha nem ilyet kap, akkor kivételt dob.
                                 Konstuktorban csak a szövegét és a prioritását kell megadni,
                                 alapértelmezetten NON_COMPLETED állapottal jön létre. Legyen egy complete() metódusa, mely átállítja az állapotát!

     */
    private static final int MIN_PRIOR = 1;
    private static final int MAX_PRIOR = 5;

    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        if(priority< MIN_PRIOR || priority> MAX_PRIOR){
            throw new IllegalArgumentException("must be between 1 and 5");
        }
        this.text = text;
        this.priority = priority;

        this.state= State.NON_COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        this.state= State.COMPLETED;
    }
}
