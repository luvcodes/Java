CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO products (product_name, price) VALUES ('Laptop', 1200.50);
INSERT INTO products (product_name, price) VALUES ('Smartphone', 650.30);
INSERT INTO products (product_name, price) VALUES ('Tablet', 300.20);

select * from products;

DELIMITER //
CREATE PROCEDURE calculate_average_price(OUT avg_price DECIMAL(10, 2))
BEGIN
    DECLARE total_price DECIMAL(10, 2);
    DECLARE total_products INT;

    SELECT SUM(price) INTO total_price FROM products;
    SELECT COUNT(id) INTO total_products FROM products;

    SET avg_price = total_price / total_products;
END //
DELIMITER ;

CALL calculate_average_price(@average);
SELECT @average AS AveragePrice;