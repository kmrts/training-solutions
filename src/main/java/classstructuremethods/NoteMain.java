package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note note= new Note();

        note.setName("Derek");
        note.setTopic("értekezlet");
        note.setText("Ma 14h-kor értekezlet!");

        note.getNoteText();
    }
}