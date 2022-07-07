
--------------------------------------------------------
--  DDL for Table product_db
--------------------------------------------------------

DROP TABLE IF EXISTS eshop.order;
CREATE TABLE IF NOT EXISTS eshop.order (
    order_id INT NOT NULL AUTO_INCREMENT,
    product_id INT,
    user_id INT,
    order_quantity INT,
    order_date VARCHAR(45),
    PRIMARY KEY (order_id));