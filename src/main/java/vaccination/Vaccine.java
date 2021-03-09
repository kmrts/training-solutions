package vaccination;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vaccine {
    private int citId;
    private boolean vaccined;

    private int times;
    private LocalDate lastDate;

    private LocalDateTime nextTime;
    private String status;
    private String type;

//    public Vaccine(int number, LocalDate last) {
//        this.number = number;
//        this.last = last;
//    }

//    public Vaccine(boolean isVaccined, int times, LocalDate lastDate) {
//        this.vaccined = isVaccined;
//        this.times = times;
//        this.lastDate = lastDate;
//    }


    public Vaccine(int citId, boolean vaccined, int times, LocalDate lastDate) {
        this.citId = citId;
        this.vaccined = vaccined;
        this.times = times;
        this.lastDate = lastDate;
    }

    public boolean isVaccined() {
        return vaccined;
    }

    public int getTimes() {
        return times;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public String getType() {
        return type;
    }

    public int getCitId() {
        return citId;
    }

    public LocalDateTime getNextTime() {
        return nextTime;
    }

    public String getStatus() {
        return status;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setNextTime(LocalDateTime nextTime) {
        this.nextTime = nextTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "citId=" + citId +
                ", vaccined=" + vaccined +
                ", times=" + times +
                ", lastDate=" + lastDate +
                ", nextTime=" + nextTime +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
