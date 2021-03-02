package activitytracker;

import org.flywaydb.core.Flyway;
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


!!  !!!
create table `activities`(id bigint auto_increment, start_time timestamp, activity_desc varchar(255),
activity_type varchar(255), primary key(id));

A main metódust egészítsd ki úgy, hogy kérdezz le egy rekordot id alapján az activities táblából.
A visszakapott ResultSet alapján példányosíts egy Activity típusú objektumot! Szervezd ki egy külön metódusba!

A main metódust egészítsd ki úgy, hogy kérdezd le az összes rekordot az activities táblából!
Példányosíts egy List<Activity> listát, amit feltöltesz a lekérdezett adatok alapján! Szervezd ki egy külön metódusba!

     */

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

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        ActivityDao acd= new ActivityDao(dataSource);
//        acd.saveActivity(activities.get(0));

        for(Activity ac: activities){
            acd.saveActivity(ac);
        }

        System.out.println(acd.findActivityById(2));

        System.out.println(acd.listActivities());


//        System.out.println(atm.selectAllActivities(dataSource));



    }


}
