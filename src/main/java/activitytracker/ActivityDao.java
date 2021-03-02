package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
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
            int id= executeAndGetGeneratedKey(stmt);
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
