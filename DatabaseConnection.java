import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_system",
                "root",
                "your_password"
            );

            return conn;

        } catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
}