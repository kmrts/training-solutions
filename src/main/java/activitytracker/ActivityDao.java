package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    /*
    Hozz létre egy ActivityDao osztályt, mely a következő metódusokat tartalmazza:

void saveActivity(Activity)
Activity findActivityById(long id)
List<Activity> listActivities()
Töröld ki az adatbázisban a táblát, és használd a Flyway-t, hogy hozza létre a sémát!

Írj egy JUnit integrációs tesztet az ActivityDao tesztelésére!

Generált azonosító lekérdezése
Módosítsd úgy a void saveActivity(Activity) metódust, hogy Activity-t adjon vissza, aminek már fel van töltve az id mezője!

Az Activity tartalmazzon egy List<TrackPoint> attribútumot! Módosítsd a saveActivity() metódust,
hogy egy tranzakcióban mentse le a TrackPoint objektumokat is a track_point táblába. Hozd létre a táblát!
A track_point táblának egy külső kulcsot kell tartalmaznia az activities táblára.

Módosítsd a findActivityById() metódust, hogy betöltse a TrackPoint értékeket is!


CREATE TABLE `track_point`(id BIGINT AUTO_INCREMENT,
time DATE, lat DOUBLE, lon DOUBLE, activity_id BIGINT,
PRIMARY KEY(id),
FOREIGN KEY(`activity_id`) REFERENCES `activities`(`id`) );

Írj rá tesztesetet!

Szabályok a koordinátákra:
    Szélesség : +90 - -90
    Hosszúság : +180 - -180

Amennyiben valamelyik pont nem felel meg a szabályoknak, vissza kell görgetni a tranzakciót, és kivételt kell dobni.
     */
    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) " +
                                "values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            insertActivity(stmt, activity);
            int id = executeAndGetGeneratedKey(stmt);
            saveTrackPoints(activity.getTrackPoints(), id);
            return findActivityById(id);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }

    }

    private void insertActivity(PreparedStatement stmt, Activity ac) throws SQLException {  //static
        stmt.setTimestamp(1, Timestamp.valueOf(ac.getStartTime()));
        stmt.setString(2, ac.getDesc());
        stmt.setString(3, ac.getType().toString());
        stmt.executeUpdate();
    }

    private int executeAndGetGeneratedKey(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.getGeneratedKeys();
        ) {
            if (rs.next()) {
                return rs.getInt(1);    //getLong
            } else {
                throw new SQLException("No key has generated");
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    private void saveTrackPoints(List<TrackPoint> trackPoints, int actId) {
        try (
                Connection conn = dataSource.getConnection();

        ) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement("insert into track_point(time, lat, lon, activity_id) " +
                    "values (?, ?, ?, ?)")) {
                for (TrackPoint trp : trackPoints) {
                    if(isValidLatLon(trp.getLat(), trp.getLon())){
                        stmt.setDate(1, Date.valueOf(trp.getTime()));
                        stmt.setDouble(2, trp.getLat());
                        stmt.setDouble(3, trp.getLon());
                        stmt.setInt(4, actId);
                        stmt.executeUpdate();
                    }else{
                        throw new IllegalArgumentException("Invalid lat or lon");
                    }
                }
                conn.commit();
            }catch (IllegalArgumentException iae){
                conn.rollback();
            }


        } catch (SQLException se) {
            throw new IllegalStateException("cannot save", se);
        }
    }
    private boolean isValidLatLon(double lat, double lon){
        if(lat< -90 || lat> 90){
            return false;
        }
        if(lon< -180 || lon> 180){
            return false;
        }
        return true;

    }

    public Activity findActivityById(int id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from activities where id = ?");
        ) {
            stmt.setInt(1, id);

            return selectByStmt(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    private Activity selectByStmt(PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Activity ac = getActivity(rs);
                return ac;
            }
            throw new IllegalArgumentException("No result");
        }
    }

    private Activity getActivity(ResultSet rs) throws SQLException {
        Activity ac = new Activity(rs.getInt("id"),
                rs.getTimestamp("start_time").toLocalDateTime(),
                rs.getString("activity_desc"),
                ActivityType.valueOf(rs.getString("activity_type"))
        );
        return ac;
    }

    public List<Activity> listActivities() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from activities order by id")
        ) {
            List<Activity> res = new ArrayList<>();
            while (rs.next()) {
                res.add(getActivity(rs));
            }
            return res;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

}
