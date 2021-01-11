package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities = new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
    //Le lehet kérdezni a track-es illetve a track nélküli listaelemeket.
    // Valamint típusonként külön-külön a távolságot egy Report-okat tartalmazó listába

//    public List<Report> distancesByTypes(){
//        List<Report> reports= new ArrayList<>();

//        for(Activity a: activities){
//            ActivityType type= a.getType();
//            double dist= a.getDistance();
//            int index=-1;
//            boolean removable= false;
//            for(Report r: reports){
////                ActivityType type= a.getType();
////                dist= r.getDistance();
//                if(r.getActivityType()== type){
////                    ActivityType type= a.getType();
////                    double dist= r.getDistance();
//                    dist+= r.getDistance();
//                    index=reports.indexOf(r);
//                    removable= true;
////                    reports.remove(r); //
////                    reports.add(new Report(type, dist));
//                    break;
//                }
//            }
//            if(removable){
//                reports.set(index, new Report(type, dist));
//            }else{
//                reports.add(new Report(type, dist));
//            }
//        }
//        return reports;
//    }

    public List<Report> distancesByTypes(){
        List<Report> reports= new ArrayList<>();
        for(ActivityType at: ActivityType.values()){ ///típusok szerint kell felépíteni a listát
            reports.add(new Report(at, 0));
        }
        for(Activity a: activities){
            ActivityType type= a.getType();
            double dist= a.getDistance();
            int index=-1;
            for(Report r: reports){

                if(r.getActivityType()== type){

                    dist+= r.getDistance();
                    index=reports.indexOf(r);
                    break;
                }
            }
            reports.set(index, new Report(type, dist));
        }
        return reports;
    }


    public int numberOfTrackActivities() {
        int num = 0;
        for (Activity a : activities) {
            if (a instanceof ActivityWithTrack) {
                num++;
            }
        }
        return num;
    }

    public int numberOfWithoutTrackActivities() {
        int num = 0;
        for (Activity a : activities) {
            if (a instanceof ActivityWithoutTrack) {
                num++;
            }
        }
        return num;
    }
}
