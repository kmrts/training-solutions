package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints= new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
    public void addTrackPoint(TrackPoint trp){
        trackPoints.add(trp);
    }
    //Le lehet kérdezni az összemelkedést, az össztávolságot.
    // alamint a pontokat, mint függvényt elképzelve a bennfoglaló téglalap területét
    public Coordinate findMaximumCoordinate(){
        double maxLatitude= Double.MIN_VALUE;
        double maxLongitude= Double.MIN_VALUE;
        for(TrackPoint trp: trackPoints){
            if(trp.getCoordinate().getLatitude()> maxLatitude){
                maxLatitude= trp.getCoordinate().getLatitude();
            }
            if(trp.getCoordinate().getLongitude()> maxLongitude){
                maxLongitude= trp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLatitude, maxLongitude);
    }
    public Coordinate findMinimumCoordinate(){
        double minLatitude= Double.MAX_VALUE;
        double minLongitude= Double.MAX_VALUE;
        for(TrackPoint trp: trackPoints){
            if(trp.getCoordinate().getLatitude()< minLatitude){
                minLatitude= trp.getCoordinate().getLatitude();
            }
            if(trp.getCoordinate().getLongitude()< minLongitude){
                minLongitude= trp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLatitude, minLongitude);
    }
    public double getDistance(){
        double fullDistance=0;
        if(trackPoints.size()> 1){
            for(int i=1; i<trackPoints.size(); i++){
                fullDistance+= trackPoints.get(i).getDistanceFrom(trackPoints.get(i-1));
            }
        }
        return fullDistance;
    }

    public double getFullElevation(){
        double fullElev=0;
        if(trackPoints.size()> 1){
            for(int i=1; i<trackPoints.size(); i++){
                if(trackPoints.get(i).getElevation()> trackPoints.get(i-1).getElevation()){
                    fullElev+= trackPoints.get(i).getElevation() - trackPoints.get(i-1).getElevation();
                }
            }
        }
        return fullElev;
    }
    public double getFullDecrease(){
        double fullDecrease= 0;
        if(trackPoints.size()> 1){
            for(int i=1; i<trackPoints.size(); i++){
                if(trackPoints.get(i).getElevation()< trackPoints.get(i-1).getElevation()){
                    fullDecrease+= trackPoints.get(i-1).getElevation() - trackPoints.get(i).getElevation();
                }
            }
        }
        return fullDecrease;
    }

    public double getRectangleArea(){
        double lati= findMaximumCoordinate().getLatitude()- findMinimumCoordinate().getLatitude();
        double longi=findMaximumCoordinate().getLongitude()- findMinimumCoordinate().getLongitude();

        return lati * longi;
    }

//    public double getRectangleArea2(){
//        Coordinate ba= findMinimumCoordinate();
//        Coordinate ja= new Coordinate(findMinimumCoordinate().getLatitude(), findMaximumCoordinate().getLongitude());
//        double lonDist= new TrackPoint(ba, 0).getDistanceFrom(new TrackPoint(ja, 0)) /1000; // km
//
//        Coordinate jf= findMaximumCoordinate();
//        Coordinate bf= new Coordinate(findMaximumCoordinate().getLatitude(), findMinimumCoordinate().getLongitude());
//        double latDist= new TrackPoint(ba, 0).getDistanceFrom(new TrackPoint(bf, 0)) /1000;
//
//        return latDist* lonDist /1000; //1000 km2
//    }
}
