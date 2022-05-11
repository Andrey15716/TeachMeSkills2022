--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS eshop_cart;
CREATE SCHEMA IF NOT EXISTS eshop_cart;

--------------------------------------------------------
--  DDL for Table product_db
--------------------------------------------------------

DROP TABLE IF EXISTS eshop.cart;
CREATE TABLE IF NOT EXISTS eshop.cart (
    user_id INT NOT NULL AUTO_INCREMENT,
    product_id INT NOT NULL,
    PRIMARY KEY (user_id));

--------------------------------------------------------
--  DML for Table product_db
--------------------------------------------------------
INSERT INTO eshop.products(user_id, product_id) value (1,1);
