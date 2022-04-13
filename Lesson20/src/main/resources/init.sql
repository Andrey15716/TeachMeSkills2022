--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS shop;
CREATE SCHEMA IF NOT EXISTS shop;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------
DROP TABLE IF EXISTS shop.product;
CREATE TABLE IF NOT EXISTS shop.product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(100) NOT NULL,
    available VARCHAR(100) NOT NULL,
    amount INT NOT NULL,
    price INT NOT NULL,
    PRIMARY KEY (id));

DROP TABLE IF EXISTS shop.user;
CREATE TABLE IF NOT EXISTS shop.user (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    PRIMARY KEY (id));

--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------
INSERT INTO shop.product(name, description, available, amount, price) VALUES('Iphone', 'Mobile', 'yes', 22, 15);
INSERT INTO shop.product(name, description, available, amount, price) VALUES('GPS', 'Navigator', 'yes', 12, 10);
INSERT INTO shop.product(name, description, available, amount, price) VALUES('Samsung', 'A53', 'no', 11, 13);
INSERT INTO shop.product(name, description, available, amount, price) VALUES('Asus', 'Laptop', 'yes', 32, 18);
INSERT INTO shop.product(name, description, available, amount, price) VALUES('TV', 'Television', 'yes', 25, 19);



INSERT INTO shop.usr(name, surname) VALUES('Andrey', 'Andreev');
INSERT INTO shop.usr(name, surname) VALUES('Ivan', 'Ivanov');
INSERT INTO shop.usr(name, surname) VALUES('Vlad', 'Vladov');
INSERT INTO shop.usr(name, surname) VALUES('Mike', 'Mikson');
INSERT INTO shop.usr(name, surname) VALUES('Anna', 'Annova');