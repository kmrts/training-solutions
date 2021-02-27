package activitytracker;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Activity {
    /*
    Írj egy activitytracker.Activity osztályt, mely attribútumai:

    id - egyedi azonosító, egész szám
    startTime - kezdési idő, LocalDateTime
    desc - szöveges leírás
    type - felsorolásos típus, mely felveheti a következő értékeket: BIKING, HIKING, RUNNING, BASKETBALL

     */
    private int id;
    private LocalDateTime startTime;
    private String desc;
    private ActivityType type;

    public Activity(int id, LocalDateTime startTime, String desc, ActivityType type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(LocalDateTime startTime, String desc, ActivityType type) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }
}
