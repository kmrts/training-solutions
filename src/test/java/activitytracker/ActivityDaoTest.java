package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    MariaDbDataSource dataSource;

    @BeforeEach
    void init(){

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

    }

    @Test
    void saveActivity() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(LocalDateTime.of(2020, 5, 2, 10, 10, 10),
                "hiking somewhere", ActivityType.HIKING));
        activities.add(new Activity(LocalDateTime.of(2020, 5, 3, 10, 10, 10),
                "bb with Kovács néni", ActivityType.BASKETBALL));
        activities.add(new Activity(LocalDateTime.of(2020, 5, 5, 10, 10, 10),
                "run with the dogs tonight", ActivityType.RUNNING));

        ActivityDao acd= new ActivityDao(dataSource);
        System.out.println(acd.saveActivity(activities.get(1)) );

    }

    @Test
    void findActivityById() {
        ActivityDao acd= new ActivityDao(dataSource);
        Activity activity= acd.findActivityById(1);
        assertEquals(ActivityType.BASKETBALL, acd.findActivityById(1).getType());
        assertEquals("kosár", acd.findActivityById(1).getDesc());
    }

    @Test
    void listActivities() {
        ActivityDao activityDao= new ActivityDao(dataSource);
        activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 1, 25, 12, 31, 0),
                "run with the dogs tonight", ActivityType.RUNNING));

        System.out.println(activityDao.listActivities());
        assertEquals(25, activityDao.listActivities().get(1).getStartTime().getDayOfMonth());
    }

    @Test
    public void insertAndCheckById(){
        ActivityDao acd= new ActivityDao(dataSource);
        Activity probe= acd.saveActivity(new Activity(LocalDateTime.of(2021, 2, 15, 12, 22, 0),
                "hiking in Pilis", ActivityType.HIKING));
        assertEquals(22, acd.findActivityById(probe.getId()).getStartTime().getMinute());
        assertEquals(ActivityType.HIKING, acd.findActivityById(probe.getId()).getType());

    }
    @Test
    public void testSaveTrackPoints(){
        ActivityDao ad= new ActivityDao(dataSource);
        Activity activity= new Activity(LocalDateTime.of(2021, 1, 25, 12, 31, 0),
                "run with the dogs tonight", ActivityType.RUNNING);
        activity.addTrackPoint(new TrackPoint(LocalDate.of(2021, 1, 10), 80, 50));
        activity.addTrackPoint(new TrackPoint(LocalDate.of(2021, 1, 10), 81, 50));
        activity.addTrackPoint(new TrackPoint(LocalDate.of(2021, 1, 11), 81, 51));

        ad.saveActivity(activity);
    }
}