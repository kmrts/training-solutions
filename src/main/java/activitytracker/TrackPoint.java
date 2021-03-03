package activitytracker;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collections;

public class TrackPoint {
    /*
    Az aktivitásokhoz pontokat is lehet felvinni, ha pl. GPS-szel nyomon követtük a mozgásunk, pl. a futásunk.
Írj egy TrackPoint osztályt, melynek attribútumai:

    id - egyedi azonosító
    time - LocalDate
    lat és lon - koordináták, szélességi és hosszúsági fok

     */
    private long id;
    private LocalDate time;
    private double lat;
    private double lon;

    public TrackPoint(long id, LocalDate time, double lat, double lon) {
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(LocalDate time, double lat, double lon) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public long getId() {
        return id;
    }

    public LocalDate getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "TrackPoint{" +
                "id=" + id +
                ", time=" + time +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}

