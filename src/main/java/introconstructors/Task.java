package introconstructors;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private String duration;

    // fordítás utáni konstruktor:
//    public Task() {
//    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    } // a következő fordítás felülírta ezzel

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void start() {
        this.startDateTime= LocalDateTime.now();
    }

    public static void main(String[] args) {
        Task task= new Task("seprés", "A padló felseprése");

        task.setDuration("10 p");
        task.start();

        System.out.println("művelet: "+ task.getTitle() +": "+ task.getDescription());
        System.out.println("kezdés: "+ task.getStartDateTime()+ " időtartam: "+ task.getDuration());
    }
}

