package exam02.photo;


public class Photo implements Qualified {
    /*
    Írj egy Photo osztályt, melynek van egy neve és egy minősítése! Létre lehet hozni csak névvel, vagy névvel és minősítéssel.
    A minősítés egy Quality enum, hogy a felhasználó hány csillagot adott rá, lehet ez Quality.NO_STAR, Quality.ONE_STAR
    és Quality.TWO_STAR.
    A Photo osztály implementálja a Qualified interfészt, melynek definiált a Quality getQuality()
    és a void setQuality(Quality) metódusa.

     */
    private String name;
    private Quality quality;

    public Photo(String name) {
        this.name = name;
        this.quality= Quality.NO_STAR;
    }

    public Photo(String name, Quality quality) {
        this.name = name;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality= quality;
    }
}
