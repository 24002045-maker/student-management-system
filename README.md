# Student Management System

A desktop application developed using Java Swing and MySQL to manage student records. The system provides a graphical user interface (GUI) that allows users to add, view, update, and delete student information.

## Features

- Add new student records
- View all students
- Update existing student information
- Delete student records
- MySQL database integration
- Object-Oriented Programming (OOP) design

## Technologies Used

- Java
- Java Swing
- MySQL
- JDBC
- VS Code

## Project Structure

```text
student-management-system/
├── Main.java
├── Student.java
├── DatabaseConnection.java
├── MySQL.session.sql
├── README.md
├── .gitignore
├── lib/
│   └── mysql-connector-j-9.7.0.jar
└── .vscode/
    ├── settings.json
    └── launch.json
```

## Database Setup

1. Open MySQL.
2. Run the SQL script in `MySQL.session.sql`.
3. This will create the database `student_system` and the `students` table.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/24002045-maker/student-management-system.git
cd student-management-system
```

2. Make sure the MySQL Connector JAR is in the `lib` folder.

3. Update your MySQL username and password in `DatabaseConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/student_system";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

4. Run `Main.java`.

## GUI Functions

### Add Student
Enter the student's ID, name, age, and GPA, then click **Add Student**.

### View Students
Displays all student records stored in the database.

### Update Student
Modify a student's information using their ID.

### Delete Student
Remove a student record using their ID.

## Example Data

| ID | Name      | Age | GPA |
|-----|----------|-----|-----|
| 1   | John Doe | 20  | 3.8 |
| 2   | Alice Lee| 21  | 3.9 |

## Author

Đinh Quang Hiếu

GitHub: https://github.com/24002045-maker

## License

This project is created for educational purposes.
