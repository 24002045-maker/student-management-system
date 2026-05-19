import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scenario3 {
    public static void main(String[] args) {

        try {
            // Connect to MySQL database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_system",
                "root",
                "123456"
            );

            // Create Statement object
            Statement stmt = con.createStatement();

            // Scenario 3:
            // 1. Delete related enrollment records for student_id = 1
            int enrollmentsDeleted = stmt.executeUpdate(
                "DELETE FROM enrollments WHERE student_id = 1"
            );
            System.out.println(enrollmentsDeleted +
                               " enrollment record(s) deleted.");

            // 2. Delete the student record
            int studentsDeleted = stmt.executeUpdate(
                "DELETE FROM students WHERE id = 1"
            );
            System.out.println(studentsDeleted +
                               " student record(s) deleted.");

            // 3. Verify that the student no longer exists
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM students WHERE id = 1"
            );

            if (!rs.next()) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student still exists.");
            }

            System.out.println("Scenario 3 executed successfully.");

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}