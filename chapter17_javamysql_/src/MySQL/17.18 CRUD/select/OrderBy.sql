USE sql_store;

-- SELECT name, unit_price * 1.1 + 10 AS new_price
-- FROM products
-- ORDER BY new_price DESC;

-- SELECT * FROM order_items
-- WHERE order_Id = 2
-- ORDER BY quantity * unit_price DESC;

SELECT *, quantity * unit_price AS total_price
FROM order_items
WHERE order_id = 2
ORDER BY total_price DESC;