package controlselection.month;

public class DayInMonth {

    public int numDays(int year, String month){
        boolean isLeapYear= false;
        if(year%4==0){
            isLeapYear= true;
            if(year%100==0){
                isLeapYear= false;
                if(year%400==0){
                    isLeapYear= true;
                }
            }
        }
        //kisbet
        int daynum= 0;
        month= month.toLowerCase();
        switch (month){
            case "január":
                daynum= 31;
                break;
            case "február":
                if (isLeapYear){
                    daynum= 29;
                }else{
                    daynum= 28;
                }
                break;
            case "március":
                daynum= 31;
                break;
            case "április":
                daynum= 30;
                break;
            case "május":
                daynum= 31;
                break;
            case "június":
                daynum= 30;
                break;
            case "július":
                daynum= 31;
                break;
            case "augusztus":
                daynum= 31;
                break;
            case "szeptember":
                daynum= 30;
                break;
            case "október":
                daynum= 31;
                break;
            case "november":
                daynum= 30;
                break;
            case "december":
                daynum= 31;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return daynum;
    }

    public static void main(String[] args) {
        DayInMonth dm= new DayInMonth();

        System.out.println(dm.numDays(1980, "február"));
        System.out.println(dm.numDays(1900, "február"));
        System.out.println(dm.numDays(2000, "február"));
        System.out.println(dm.numDays(2020, "November"));
        System.out.println(dm.numDays(2020, "febcius"));
    }
}
