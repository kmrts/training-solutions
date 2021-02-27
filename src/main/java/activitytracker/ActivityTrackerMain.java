package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    /*
    Írj egy activitytracker.ActivityTrackerMain osztályt, mely egy main() metódusban,
    mely példányosít pár Activity példányt, és értéküket beszúrja az activities táblába!

    Az adatbázisban hozd létre az activities táblát!
    Az id legyen auto_generated!
    A mezőnevek legyenek hasonlóak az osztály attribútumainak neveihez, azonban a szavakat aláhúzásjel (_) válassza el!
    Mivel a desc és a type foglalt szó, ezért ezen oszlopok neve legyen activity_desc és activity_type.

A LocalDateTime értéket JDBC-vel a ResultSet.setTimestamp() metódussal lehet beszúrni.
Létrehozni a Timestamp.valueOf(LocalDateTime) metódussal lehet.

Amennyiben kész, szervezd ki a beszúrást egy külön metódusba!



create table `activities`(id bigint auto_increment, start_time timestamp, activity_desc varchar(255),
activity_type varchar(255), primary key(id));

A main metódust egészítsd ki úgy, hogy kérdezz le egy rekordot id alapján az activities táblából.
A visszakapott ResultSet alapján példányosíts egy Activity típusú objektumot! Szervezd ki egy külön metódusba!

A main metódust egészítsd ki úgy, hogy kérdezd le az összes rekordot az activities táblából!
Példányosíts egy List<Activity> listát, amit feltöltesz a lekérdezett adatok alapján! Szervezd ki egy külön metódusba!

     */

    private static void insertActivity(PreparedStatement stmt, Activity ac) throws SQLException {
        stmt.setTimestamp(1, Timestamp.valueOf(ac.getStartTime()) );
        stmt.setString(2, ac.getDesc());
        stmt.setString(3, ac.getType().toString());
        stmt.executeUpdate();
    }

    public Activity selectActivity(DataSource dataSource, int id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from activities where id = ?");
        ) {
            stmt.setInt(1, id);

            return selectActivityByStmt(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    private Activity selectActivityByStmt(PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()  ) {
            if (rs.next()) {
                return new Activity(rs.getInt("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type"))
                        );
            }
            throw new IllegalArgumentException("No result");
        }
    }

//    public List<Activity> selectAllActivities(DataSource dataSource){
//
//
//        try (
//                Connection conn = dataSource.getConnection();
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("select * from activities order by id")
//        ) {
//            List<Activity> res = new ArrayList<>();
//            while (rs.next()) {
//                res.add(selectActivityByStmt(stmt));
//            }
//            return res;
//        }
//        catch (SQLException se) {
//            throw new IllegalStateException("Cannot select employees", se);
//        }
//    }

    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(LocalDateTime.of(2020, 5, 2, 10, 10, 10),
                "hiking somewhere", ActivityType.HIKING));
        activities.add(new Activity(LocalDateTime.of(2020, 5, 3, 10, 10, 10),
                "bb with KovacsNeni", ActivityType.BASKETBALL));
        activities.add(new Activity(LocalDateTime.of(2020, 5, 5, 10, 10, 10),
                "run with the dogs tonight", ActivityType.RUNNING));


        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");  //

            dataSource.setUser("activitytracker"); //
            dataSource.setPassword("activitytracker"); //
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

        ActivityTrackerMain atm= new ActivityTrackerMain();

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) " +
                                "values (?, ?, ?)")
        ) {
            for(Activity ac: activities){
                insertActivity(stmt, ac);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }

        System.out.println(atm.selectActivity(dataSource, 3) );



    }


}
