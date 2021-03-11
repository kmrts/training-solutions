package vaccination;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VaccDaoTest {

    VaccDao vd;

    @BeforeEach
    public void init(){
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccin1?useUnicode=true");
            dataSource.setUser("vaccin1");
            dataSource.setPassword("vaccin1");

        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        Flyway flyway = Flyway.configure().locations("/db/migration/vaccination").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        vd = new VaccDao(dataSource);
    }

    @Test
    public void writeCityFromZipTest(){

        assertEquals(List.of("Vác"), vd.writeCityFromZip("2600") );
    }

    @Test
    public void saveAndReadCitizenTest(){
        vd.saveCitizen(new Citizen("Jose", "8400", 51, "jose@bu.hu", "333333330"));

        Vaccine vacc= vd.readDataFromCitizen("333333330");

        assertEquals(1, vacc.getCitId() );
        assertFalse(vacc.isVaccined());
        assertEquals(0, vacc.getTimes());

    }
    @Test
    public void vaccInAndReadTypeTest(){
        vd.saveCitizen(new Citizen("Jose", "8400", 51, "jose@bu.hu", "333333330"));
        Vaccine vacc= new Vaccine(1, false, 1, LocalDate.of(2021, 3, 10));
        vacc.setType("novapowa");
        vacc.setStatus("first");
        vacc.setNextTime(LocalDateTime.of(2021, 3, 10, 12, 20, 0));
        vd.vaccIn(vacc);

        assertEquals("novapowa", vd.readTypeFromVacTable(1));

    }
    @Test
    public void doFailedTest(){
        vd.saveCitizen(new Citizen("Jose", "3400", 51, "jose@bu.hu", "333333330"));
//        Vaccine vacc= new Vaccine(1, false, 1, LocalDate.of(2021, 3, 5));
        vd.doFailed(1, LocalDateTime.of(2021, 3, 11, 10, 5), "failed",
                "nem jelent meg");
        //nincs lekérő metód.

    }
    @Test
    void getNumOfVaccByZipTest(){
        vd.saveCitizen(new Citizen("Jose", "3500", 51, "jose@bu.hu", "333333330"));

        Map<String, List<Integer>> result= vd.getNumOfVaccByZip();
        assertEquals(1, result.size());
//        System.out.println(result.get("3500"));

        assertTrue(result.containsValue(List.of(1,0,0)));
    }

}