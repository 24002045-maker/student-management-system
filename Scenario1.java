import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Scenario1 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_system",
                "root",
                "123456"
            );
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                "INSERT INTO students VALUES (1, 'An', 20, 0.0)"
            );
            stmt.executeUpdate(
                "INSERT INTO courses VALUES (101, 'OOP')"
            );
            stmt.executeUpdate(
                "INSERT INTO enrollments VALUES (1, 101, 'A')"
            );
            stmt.executeUpdate(
                "UPDATE students SET gpa = 4.0 WHERE id = 1"
            );
            System.out.println("Scenario 1 executed successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}