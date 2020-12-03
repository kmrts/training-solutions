package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if(!isCorrect(year, month, day)){
            throw new IllegalArgumentException(String.format("One or more given parameter cannot be applied! %d, %d, %d", year, month, day));
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    private boolean isCorrect(int year, int month, int day){
        return year>= 1900 && month>=1 && month <= 12
                && day<=calculateMonthLength(year, month) && day>0 ? true : false;
    }
    private int calculateMonthLength(int year, int month){
        int length= 0;
        switch(month){
            case 1, 3, 5, 7, 8, 10, 12:
                length= 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                length= 30;
                break;
            case 2:
                length= isLeapYear(year) ? 29 : 28;
                break;
        }
        return length;
    }
    private boolean isLeapYear(int year){
//        if(year%400==0){
//            return true;
//        }else if(year%100==0){
//            return false;
//        }else if(year%4==0){
//            return true;
//        }else{
//            return false;
//        }
        return year%400==0 ? true : (year%100==0 ? false : (year%4==0 ? true : false));
    }
}
