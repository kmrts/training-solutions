package statements;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public int getInMinutes(){
        return hour*60+ minute;
    }
    public int getInSeconds(){
        return hour*60*60+ minute*60+ second;
    }
}
