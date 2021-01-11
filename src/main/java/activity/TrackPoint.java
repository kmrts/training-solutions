package activity;

public class TrackPoint {
    private Coordinate cordinate;
    private double elevation;

    public TrackPoint(Coordinate cordinate, double elevation) {
        this.cordinate = cordinate;
        this.elevation = elevation;
    }
    //    public TrackPoint(Coordinate cordinate) {
//        this.cordinate = cordinate;
//    }

    public Coordinate getCoordinate() {
        return cordinate;
    }

    public double getElevation() {
        return elevation;
    }
    public double getDistanceFrom(TrackPoint point){
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(point.getCoordinate().getLatitude() - cordinate.getLatitude());
        double lonDistance = Math.toRadians(point.getCoordinate().getLongitude() - cordinate.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(cordinate.getLatitude())) * Math.cos(Math.toRadians(point.getCoordinate().getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
        //
        double height = elevation - point.getElevation();

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);

    }
}
