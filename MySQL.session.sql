CREATE DATABASE IF NOT EXISTS student_system;

USE student_system;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    gpa DOUBLE
);

CREATE TABLE courses (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE enrollments (
    student_id INT,
    course_id INT,
    grade CHAR(1)
);

--Scenario1
INSERT INTO students (id, name, gpa)
VALUES (1, 'An', 0);
INSERT INTO courses (id, name)
VALUES (101, 'OOP');
INSERT INTO enrollments (student_id, course_id, grade)
VALUES (1, 101, 'A');
UPDATE students
SET gpa = 4.0
WHERE id = 1;

--Scenario2
SELECT * FROM students
WHERE name = 'An';
UPDATE students
SET name = 'An Nguyen'
WHERE id = 1;