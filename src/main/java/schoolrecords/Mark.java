package schoolrecords;

public class Mark {

    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if(subject==null || tutor==null){
            throw new NullPointerException("Both subject and tutor must be provided!");
        }else{
            this.markType = markType;
            this.subject = subject;
            this.tutor = tutor;
        }

    }

    public Mark(String markType, Subject subject, Tutor tutor) {

        switch (markType){
            case "5":
            case "A":
                this.markType= MarkType.A;
                break;
            case "4":
            case "B":
                this.markType= MarkType.B;
                break;
            case "3":
            case "C":
                this.markType= MarkType.C;
                break;
            case "2":
            case "D":
                this.markType= MarkType.D;
                break;
            case "1":
            case "F":
            default:
                this.markType= MarkType.F;
                break;
        }
        this.subject = subject;
        this.tutor = tutor;
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return markType.getDescription()+"(" +markType.getValue() +")";

    }
}
