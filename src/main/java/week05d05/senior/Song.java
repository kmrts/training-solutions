package week05d05.senior;

public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if(name.isEmpty() || artist.isEmpty()){
            throw new IllegalArgumentException("name or artist is empty");
        }
        if(lengthInSeconds<=0){
            throw new IllegalArgumentException("length sould be >0");
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return artist +" - "+ name+", length: " +lengthInSeconds;

    }
}
