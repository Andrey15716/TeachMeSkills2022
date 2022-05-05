--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS shop_users;
CREATE SCHEMA IF NOT EXISTS shop_users;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------

DROP TABLE IF EXISTS shop.user;
CREATE TABLE IF NOT EXISTS shop.user (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id));

--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------

INSERT INTO shop.user(name,surname,password) value ('Andrey', 'Andreev', '123');