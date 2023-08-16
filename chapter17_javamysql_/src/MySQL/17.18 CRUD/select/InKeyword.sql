-- select * 
-- from sql_store.customers
-- where state in ('va', 'fl', 'ga');

select * 
from sql_store.products
where quantity_in_stock in (49, 38, 72);