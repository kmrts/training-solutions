package activitytracker;

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
activity_type varchar(255), constraint pk_employees primary key(id));
     */
}
