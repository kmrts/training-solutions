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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
            writeTofile(rs, fileName);

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

    private void writeTofile(ResultSet rs, String fileName) throws SQLException{ //throws SQLException
        /*
        Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám
8:00;John Doe;2061;60;john.doe@example.com;1234567890
8:30;Jack Doe;2061;40;jack.doe@example.com;1234567881
         */
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            LocalTime actTime= LocalTime.of(8, 0);
            int counter= 0;
            writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
            while (rs.next() && counter< 16) {
                if (readyForVacc(rs)) {
                    StringBuilder sb= new StringBuilder(actTime.toString());
                    sb.append(";").append(rs.getString("citizen_name"));
                    sb.append(";").append(rs.getString("zip"));
                    sb.append(";").append(rs.getInt("age"));
                    sb.append(";").append(rs.getString("email"));
                    sb.append(";").append(rs.getString("taj"));
                    sb.append("\n");

                    writer.write(sb.toString());
                    counter++;
                    actTime= actTime.plusMinutes(30);

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
        LocalDate interval= LocalDate.now().minusDays(14);

        return rs.getInt("number_of_vaccination") == 1
                && rs.getDate("last_vaccination").toLocalDate().isBefore(interval);


    }
}
