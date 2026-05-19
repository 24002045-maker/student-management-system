import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Scenario2 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_system",
                "root",
                "123456"
            );
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM students WHERE name = 'An'"
            );
            System.out.println("Students named 'An':");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                                   rs.getString("name"));
            }
            int rowsUpdated = stmt.executeUpdate(
                "UPDATE students " +
                "SET name = 'An Nguyen' " +
                "WHERE id = 1"
            );
            System.out.println(rowsUpdated + " row(s) updated.");
            System.out.println("Scenario 2 executed successfully.");
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}