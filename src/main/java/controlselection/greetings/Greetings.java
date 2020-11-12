package controlselection.greetings;

import java.time.LocalTime;
import java.util.Date;

public class Greetings {

    public String Greeting(int hour, int minute){
        LocalTime greeTime=LocalTime.of(hour, minute);
        String greet= "";
        if(greeTime.getHour()>=20  || greeTime.getHour()<5){
            greet= "Jó éjt!";
        }else if(greeTime.getHour()>=18 && greeTime.getMinute()>=30){
            return "Jó estét!";
        }else if(greeTime.getHour()>=9){
            return "Jó napot!";
        }else if(greeTime.getHour()>=5){
            return "Jó reggelt!";
        }
        return greet;
    }


    public static void main(String[] args) {
        Greetings gr= new Greetings();

        System.out.println(gr.Greeting( LocalTime.now().getHour(),LocalTime.now().getMinute()));

        System.out.println((gr.Greeting(5,0)));
        System.out.println((gr.Greeting(18,29)));
        System.out.println((gr.Greeting(18,30)));
    }
}

