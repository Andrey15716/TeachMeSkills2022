--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS eshop;
CREATE SCHEMA IF NOT EXISTS eshop;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------

DROP TABLE IF EXISTS eshop.user;
CREATE TABLE IF NOT EXISTS eshop.user (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id));

--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------

INSERT INTO eshop.user(name,surname,password) value ('Andrey', 'Andreev', '123');