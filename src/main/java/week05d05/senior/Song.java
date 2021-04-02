package week05d05.senior;

public class Song {
    /*
    az alábbi mezői vannak:

    String name
    long lengthInSeconds
    String artist

A Song konstruktorában ellenőrizd, hogy a name és az artist üres-e!
Dobj kivételt, ha igen! Ellenőrizd továbbá a lengthInSeconds-ot is, hogy nagyobb legyen, mint 0!
Készítsünk egy Playlist osztályt, melynek van egy konstruktora,
amiben Song-ok listáját fogadja el!
Írjunk egy metódust findByLengthGreaterThan néven,
mely egy int-et vár paraméterként mins néven. Azoknak a Song-oknak a listáját
adjuk vissza, melyek hosszabbak percben (!), mint a Song lengthInSeconds mezője.

Bónusz feladat: Implementáljuk megfelelően a toString metódust a Song és a Playlist osztályban,
hogy a Playliset-et kiirva a konzolra olvasható eredményt kapjunk!
     */

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
