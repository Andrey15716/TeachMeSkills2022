--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS eshop_products;
CREATE SCHEMA IF NOT EXISTS eshop_products;

--------------------------------------------------------
--  DDL for Table product_db
--------------------------------------------------------

DROP TABLE IF EXISTS eshop.products;
CREATE TABLE IF NOT EXISTS eshop.products (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(100) NOT NULL,
    imageName VARCHAR(100) NOT NULL,
    price VARCHAR(45) NOT NULL,
    PRIMARY KEY (id));

--------------------------------------------------------
--  DML for Table product_db
--------------------------------------------------------
INSERT INTO eshop.products(name, description, imageName, price) value ('Samsung_A51','Лучший мобильный телефон серии A','samsung.jpg',123);
INSERT INTO eshop.products(name, description, imageName, price) value ('Iphone_X','В качестве новинки улучшенная камера','iphone.jpg',453);
INSERT INTO eshop.products(name, description, imageName, price) value ('Xiaomi_Poco','Увеличенная емкость батареи','xiaomi.jpg',233);
INSERT INTO eshop.products(name, description, imageName, price) value ('Asus','Лучший ноутбук серии A',' ',121);
INSERT INTO eshop.products(name, description, imageName, price) value ('MacBook','В качестве новинки улучшенная камера',' ',154);
INSERT INTO eshop.products(name, description, imageName, price) value ('Xiaomi','Увеличенная емкость батареи',' ',141);
INSERT INTO eshop.products(name, description, imageName, price) value ('Samsung','Лучший навигатор серии A',' ',124);
INSERT INTO eshop.products(name, description, imageName, price) value ('Panasonic','В качестве новинки улучшенная камера',' ',45);
INSERT INTO eshop.products(name, description, imageName, price) value ('Xiaomi','Увеличенная емкость батареи',' ',24);
INSERT INTO eshop.products(name, description, imageName, price) value ('Fridge_1','Лучший холодильник серии A',' ',124);
INSERT INTO eshop.products(name, description, imageName, price) value ('Fridge_2','В качестве новинки улучшенная морозильная камера',' ',46);
INSERT INTO eshop.products(name, description, imageName, price) value ('Fridge_3','Увеличенная емкость батареи',' ',67);
INSERT INTO eshop.products(name, description, imageName, price) value ('BMW','Лучший двигатель серии A',' ',121);
INSERT INTO eshop.products(name, description, imageName, price) value ('Jaguar','В качестве новинки улучшенная коробка передач',' ',111);
INSERT INTO eshop.products(name, description, imageName, price) value ('Audi','Увеличенная емкость батареи',' ',232);
INSERT INTO eshop.products(name, description, imageName, price) value ('Photo_1','Лучшая камера серии A',' ',111);
INSERT INTO eshop.products(name, description, imageName, price) value ('Photo_2','В качестве новинки улучшенная камера',' ',124);
INSERT INTO eshop.products(name, description, imageName, price) value ('Photo_3','Увеличенная емкость батареи',' ',235);