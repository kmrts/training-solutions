package collectionsiterator;

public class MissingBookException extends RuntimeException{

    private String message;
    private int regNumber;
    private String author;

    public MissingBookException(String message, int regNumber) {
        super(message+ regNumber);

    }

    public MissingBookException(String message, String author) {
        super(message+ author);
    }

}
