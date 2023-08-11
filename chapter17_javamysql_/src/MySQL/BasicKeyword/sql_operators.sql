-- when use AND operator, both condition need to be true;
-- AND operator execute first, higher parenthesis

-- use the AND, OR, parenthesis operators
-- select * 
-- from sql_store.customers
-- where birth_date > '1990-01-01' or 
-- (points > 1000 and state = 'VA'); 

-- using the NOT keyword
-- select * 
-- from sql_store.customers
-- where NOT (birth_date > '1990-01-01' or pints > 1000);

-- exercise
select * 
from sql_store.order_items
where order_id = 6 AND (quantity * unit_price > 30);