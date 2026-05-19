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