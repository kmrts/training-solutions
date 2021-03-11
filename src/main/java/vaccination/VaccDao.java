package vaccination;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VaccDao {

    private DataSource dataSource;

    public VaccDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> writeCityFromZip(String zip) {  //

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select city from cities where zip=\"" + zip + "\"")  ///
        ) {
            List<String> cities = new ArrayList<>();
            while (rs.next()) {
                String city = rs.getString("city");
                cities.add(city);
            }
            return cities;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

    public void saveCitizen(Citizen citizen) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("insert into citizens(citizen_name, zip, age, email, taj) values (?, ?, ?, ?, ?)")) {
            stmt.setString(1, citizen.getName());
            stmt.setString(2, citizen.getZip());
            stmt.setInt(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getTaj());
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public void selectCitizensWithZip(String zip, String fileName) {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `citizens` WHERE `zip`=" + zip +
                        " ORDER BY `age` DESC, `citizen_name`")
        ) {
            writeCitizenDataTofile(rs, fileName);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

    private void writeCitizenDataTofile(ResultSet rs, String fileName) throws SQLException { //throws SQLException
        /*
        Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám
8:00;John Doe;2061;60;john.doe@example.com;1234567890
8:30;Jack Doe;2061;40;jack.doe@example.com;1234567881
         */
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            LocalTime actTime = LocalTime.of(8, 0);
            int counter = 0;
            writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
            while (rs.next() && counter < 16) {
                if (readyForVacc(rs)) {
                    StringBuilder sb = new StringBuilder(actTime.toString());
                    sb.append(";").append(rs.getString("citizen_name"));
                    sb.append(";").append(rs.getString("zip"));
                    sb.append(";").append(rs.getInt("age"));
                    sb.append(";").append(rs.getString("email"));
                    sb.append(";").append(rs.getString("taj"));
                    sb.append("\n");

                    writer.write(sb.toString());
                    counter++;
                    actTime = actTime.plusMinutes(30);

                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private boolean readyForVacc(ResultSet rs) throws SQLException {
        if (rs.getInt("number_of_vaccination") == 0) {
            return true;
        }
        LocalDate interval = LocalDate.now().minusDays(14);

        return rs.getInt("number_of_vaccination") == 1
                && rs.getDate("last_vaccination").toLocalDate().isBefore(interval);


    }

    public Vaccine readDataFromCitizen(String taj) {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `citizens` WHERE `taj`=" + taj)
        ) {
            if (rs.next()) {
                boolean isVacc = false;
                int id = rs.getInt("citizen_id");
                int num = rs.getInt("number_of_vaccination");
                LocalDate last = null;
                if (num != 0) {
                    isVacc = true;

                    last = rs.getDate("last_vaccination").toLocalDate();
                }
                return new Vaccine(id, isVacc, num, last);
            }
            System.out.println("Nem regisztrált taj-szám");
            return null;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select citizen", se);
        }
    }

    public String readTypeFromVacTable(int citId) {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT `vaccination_type` FROM `vaccinations` WHERE `citizen_id`=" + citId)
        ) {
            if (rs.next()) {

                return rs.getString("vaccination_type");
            }
            throw new IllegalArgumentException("No result");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }
    }

    public void vaccIn(Vaccine vaccine) {
        try (Connection conn = dataSource.getConnection();
        ) {
            try (PreparedStatement stmt =
                         conn.prepareStatement("insert into vaccinations(citizen_id, vaccination_date," +
                                 "status, vaccination_type) values (?, ?, ?, ?)");
                 PreparedStatement stmtCitz = conn.prepareStatement("UPDATE citizens SET number_of_vaccination=?," +
                         " last_vaccination=? WHERE citizen_id=?")) {
                stmt.setInt(1, vaccine.getCitId());
                stmt.setTimestamp(2, Timestamp.valueOf(vaccine.getNextTime()));
                stmt.setString(3, vaccine.getStatus());
                stmt.setString(4, vaccine.getType());
                stmt.executeUpdate();

                stmtCitz.setInt(1, vaccine.getTimes());
                stmtCitz.setTimestamp(2, Timestamp.valueOf(vaccine.getNextTime()));
                stmtCitz.setInt(3, vaccine.getCitId());
                stmtCitz.executeUpdate();

                conn.commit();

            } catch (IllegalArgumentException ie) {
                conn.rollback();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert or update", se);
        }
    }

    public void doFailed(int citId, LocalDateTime actualTime, String status, String note) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("insert into vaccinations(citizen_id, vaccination_date," +
                                "status, note) values (?, ?, ?, ?)")
        ) {
            stmt.setInt(1, citId);
            stmt.setTimestamp(2, Timestamp.valueOf(actualTime));
            stmt.setString(3, status);
            stmt.setString(4, note);
            stmt.executeUpdate();

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public Map<String, List<Integer>> getNumOfVaccByZip() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT zip, number_of_vaccination FROM `citizens` ORDER BY zip, number_of_vaccination")

        ) {
            Map<String, List<Integer>> zipvacc = new TreeMap<>();
            while (rs.next()) {
                String zip = rs.getString("zip");
                int number = rs.getInt("number_of_vaccination");

                if (zipvacc.containsKey(zip)) {

                    List<Integer> nextState = new ArrayList<>(zipvacc.get(zip));
                    nextState.set(number, nextState.get(number) + 1);
                    zipvacc.put(zip, nextState);
                } else {
                    List<Integer> init = new ArrayList<>(List.of(0, 0, 0));
                    init.set(number, 1);
                    zipvacc.put(zip, init);
                }
//                System.out.println(zipvacc);
            }
            return zipvacc;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select citizens", se);
        }
    }

    public void reportToFile(Map<String, List<Integer>> zipvacc, String fileName) {
        try (BufferedWriter bwr = Files.newBufferedWriter(Path.of(fileName))) {
            bwr.write("Oltási adatok irányítószámonként: \n");
            for (Map.Entry<String, List<Integer>> entry : zipvacc.entrySet()) {
                bwr.write(String.format("\n%s irányítószám adatai:\n", entry.getKey()));

                for (int i = 0; i < 3; i++) {
                    bwr.write(String.format("%d alkalommal oltottak száma: %d\n", i, entry.getValue().get(i)));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
