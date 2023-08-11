USE sql_store;

-- 6, 3 表示跳过前6个，取第7~9个，6是偏移量
-- SELECT * FROM customers
-- LIMIT 6,3;

-- SELECT * FROM customers
-- LIMIT 3;
-- 
-- SELECT * FROM customers
-- LIMIT 300;

SELECT * FROM customers
(where)
order by points desc
limit 3;