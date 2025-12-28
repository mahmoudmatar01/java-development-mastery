--DROP DATABASE IF EXISTS studentDatabase;

CREATE DATABASE studentDatabase;

USE studentDatabase;

CREATE TABLE student(
id INT(15)PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15),
gpa DOUBLE,
phone VARCHAR(11)
);
