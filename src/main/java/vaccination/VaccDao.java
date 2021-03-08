package vaccination;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
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

    public void selectCitizensWithZip(String zip) {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `citizens` WHERE `zip`=" + zip + " ORDER BY `age`")
        ) {
            List<String> citizens = new ArrayList<>();
            while (rs.next()) {
                if (readyForVacc(rs)) {

                }

//
//                cities.add(city);
            }
//            return citizens;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select", se);
        }
    }

    private boolean readyForVacc(ResultSet rs) throws SQLException {
        if (rs.getInt("number_of_vaccination") == 0) {
            return true;
        } else {
            System.out.println("not 0");
        }return false;


    }
}
