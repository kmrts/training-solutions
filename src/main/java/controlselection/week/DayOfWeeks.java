package controlselection.week;

public class DayOfWeeks {

    public String messDaily(String day){
        day= day.toLowerCase();
//        String message;
        switch (day) {
            case "hétfő":
                return "hét eleje van";
            case "kedd":
            case "szerda":
            case "csütörtök":
                return "hét közepe van";
            case "péntek":
                return "majdnem hétvége van";
            case "szombat":
            case "vasárnap":
                return "hétvége van";
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    public static void main(String[] args) {
        DayOfWeeks dw = new DayOfWeeks();

        System.out.println(dw.messDaily("Kedd"));
        System.out.println(dw.messDaily("HÉTFŐ"));
        System.out.println(dw.messDaily("csümbat"));
    }

}
