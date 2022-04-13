--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS students_db;
CREATE SCHEMA IF NOT EXISTS students_db;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------
DROP TABLE IF EXISTS students_db.students;
CREATE TABLE IF NOT EXISTS students_db.students (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    course INT NOT NULL,
    PRIMARY KEY (id));

DROP TABLE IF EXISTS students_db.city;
CREATE TABLE IF NOT EXISTS students_db.city (
    city_id INT NOT NULL AUTO_INCREMENT,
    from_city VARCHAR(45) NOT NULL,
    study_city VARCHAR(100) NOT NULL,
    PRIMARY KEY (city_id));

--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------
INSERT INTO students_db.students(name, surname, course) VALUES('Alex', 'Surkov', 1);
INSERT INTO students_db.students(name, surname, course) VALUES('Anna', 'Borodich', 2);
INSERT INTO students_db.students(name, surname, course) VALUES('Sergey', 'Kryvnitskiy', 3);
INSERT INTO students_db.students(name, surname, course) VALUES('Alina', 'Kedich', 4);
INSERT INTO students_db.students(name, surname, course) VALUES('Petr', 'Medvedzev', 5);

INSERT INTO students_db.city(from_city, study_city) VALUES('Moscow', 'Minsk');
INSERT INTO students_db.city(from_city, study_city) VALUES('Brest', 'Minsk');
INSERT INTO students_db.city(from_city, study_city) VALUES('Gomel', 'Minsk');
INSERT INTO students_db.city(from_city, study_city) VALUES('Moscow', 'Minsk');
INSERT INTO students_db.city(from_city, study_city) VALUES('Minsk', 'Minsk');