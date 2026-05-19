import javax.swing.*;
import java.sql.*;

public class Main extends JFrame {

    JTextField idField;
    JTextField nameField;
    JTextField ageField;
    JTextField gpaField;

    JTextArea outputArea;
    JButton addButton;
    JButton viewButton;
    JButton updateButton;
    JButton deleteButton;

    Connection conn;

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }

    // Constructor
    public Main() {
        setTitle("Student Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Labels
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setBounds(30, 30, 100, 25);
        add(idLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 25);
        add(nameLabel);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 110, 100, 25);
        add(ageLabel);

        JLabel gpaLabel = new JLabel("GPA:");
        gpaLabel.setBounds(30, 150, 100, 25);
        add(gpaLabel);

        // Text fields
        idField = new JTextField();
        idField.setBounds(130, 30, 200, 25);
        add(idField);

        nameField = new JTextField();
        nameField.setBounds(130, 70, 200, 25);
        add(nameField);

        ageField = new JTextField();
        ageField.setBounds(130, 110, 200, 25);
        add(ageField);

        gpaField = new JTextField();
        gpaField.setBounds(130, 150, 200, 25);
        add(gpaField);

        // Buttons
        addButton = new JButton("Add Student");
        addButton.setBounds(400, 30, 180, 30);
        add(addButton);

        viewButton = new JButton("View Students");
        viewButton.setBounds(400, 70, 180, 30);
        add(viewButton);

        updateButton = new JButton("Update Student");
        updateButton.setBounds(400, 110, 180, 30);
        add(updateButton);

        deleteButton = new JButton("Delete Student");
        deleteButton.setBounds(400, 150, 180, 30);
        add(deleteButton);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(30, 220, 620, 200);
        add(scrollPane);

        // Connect to database
        connectDatabase();

        // Button actions
        addButton.addActionListener(e -> addStudent());
        viewButton.addActionListener(e -> viewStudents());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());

        setVisible(true);
    }

    // Database connection
    public void connectDatabase() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_system",
                "root",
                "123456"   // Replace with your MySQL password
            );

            outputArea.setText("Connected to MySQL Database Successfully.\n");

        } catch (Exception e) {
            outputArea.setText("Database Connection Failed:\n" + e);
            e.printStackTrace();
        }
    }

    // Add student
    public void addStudent() {
        if (conn == null) {
            outputArea.setText("Database connection is null.");
            return;
        }

        try {
            String query =
                "INSERT INTO students(id, name, age, gpa) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.setString(2, nameField.getText());
            stmt.setInt(3, Integer.parseInt(ageField.getText()));
            stmt.setDouble(4, Double.parseDouble(gpaField.getText()));

            stmt.executeUpdate();

            outputArea.setText("Student added successfully.");

        } catch (Exception e) {
            outputArea.setText(e.toString());
        }
    }

    // View students
    public void viewStudents() {
        if (conn == null) {
            outputArea.setText("Database connection is null.");
            return;
        }

        try {
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            outputArea.setText("");

            while (rs.next()) {
                outputArea.append(
                    "ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Age: " + rs.getInt("age") +
                    " | GPA: " + rs.getDouble("gpa") +
                    "\n"
                );
            }

        } catch (Exception e) {
            outputArea.setText(e.toString());
        }
    }

    // Update student
    public void updateStudent() {
        if (conn == null) {
            outputArea.setText("Database connection is null.");
            return;
        }

        try {
            String query =
                "UPDATE students SET name=?, age=?, gpa=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, nameField.getText());
            stmt.setInt(2, Integer.parseInt(ageField.getText()));
            stmt.setDouble(3, Double.parseDouble(gpaField.getText()));
            stmt.setInt(4, Integer.parseInt(idField.getText()));

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                outputArea.setText("Student updated successfully.");
            } else {
                outputArea.setText("Student ID not found.");
            }

        } catch (Exception e) {
            outputArea.setText(e.toString());
        }
    }

    // Delete student
    public void deleteStudent() {
        if (conn == null) {
            outputArea.setText("Database connection is null.");
            return;
        }

        try {
            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(idField.getText()));

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                outputArea.setText("Student deleted successfully.");
            } else {
                outputArea.setText("Student ID not found.");
            }

        } catch (Exception e) {
            outputArea.setText(e.toString());
        }
    }
}