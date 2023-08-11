-- USE sql_store;
-- 
-- SELECT * FROM customers WHERE phone is null;
-- -- SELECT * FROM customers WHERE phone IS NOT NULL;

USE sql_store;
SELECT * FROM orders WHERE shipper_id is NULL;