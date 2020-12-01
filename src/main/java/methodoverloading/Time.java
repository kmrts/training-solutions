package methodoverloading;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = 0;
    }

    public Time(int hours) {
        this.hours = hours;
        this.minutes = 0;
        this.seconds = 0;
    }
    public Time(Time time){
        this.hours= time.getHours();
        this.minutes= time.getMinutes();
        this.seconds= time.getSeconds();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
    public boolean isEqual(Time time){
//        if(hours==time.getHours() && minutes==time.getMinutes()&& seconds== time.getSeconds()){
//            return true;
//        }
//        return false;
        return (toSeconds(time.getHours(), time.getMinutes(), time.getSeconds())== toSeconds(hours, minutes, seconds));
    }
    public boolean isEqual(int hours, int minutes, int seconds){
//        if(this.hours==hours && this.minutes==minutes && this.seconds== seconds){
//            return true;
//        }
//        return false;
        return (toSeconds(hours, minutes, seconds) == toSeconds(this.hours, this.minutes, this.seconds) );
    }
    public boolean isEarlier(Time time){
        return (toSeconds(time.getHours(), time.getMinutes(), time.getSeconds())> toSeconds(hours, minutes, seconds) );
    }
    public boolean isEarlier(int hours, int minutes, int seconds){
        return (toSeconds(hours, minutes, seconds)> toSeconds(this.hours, this.minutes, this.seconds) );
    }

    public int toSeconds(Time time){
        return time.getHours()*60*60+ time.getMinutes()*60+ time.getMinutes();
    }

    public int toSeconds(int hours, int minutes, int seconds){
//        return time.getHours()*60*60+ time.getMinutes()*60+ time.getMinutes();
        return hours*60*60+ minutes*60+ seconds;
   }
    public int toSeconds(){  ///
        return hours*60*60+ minutes*60+ seconds;
    }
}
