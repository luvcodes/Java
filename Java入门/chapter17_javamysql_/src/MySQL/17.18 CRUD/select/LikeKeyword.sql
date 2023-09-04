-- % any number of characters
-- _ single character

-- For search purpose
-- start character with brush
select * 
from sql_store.customers
where last_name like 'brush%';

-- search for lastname that have 'b' in them
-- b前后可以又任意字符数
select * 
from sql_store.customers
where last_name like '%b%';

-- 最后一位是y
select *
from sql_store.customers
where last_name like '%y';

-- 这样会输出lastname是两个字符的，无所谓第一个字符是什么
-- 但是第二个字符是y
-- 如果改成5个_， 那么就是lastname是6位，最后一位是y
select * 
from sql_store.customers
where last_name like '_y';

-- 这样会输出lastname是六个字符的
-- 第一位是b，后面跟4位，最后一位是y
select * 
from sql_store.customers
where last_name like 'b____y';

-- exercise1
-- 我理解这里不能用in的原因是因为，In可以整体性地查找目标是不是包含在这一列属性中，
-- 但是不能查找某个属性值中的一部分。
select * 
from sql_store.customers
where address like '%TRAIL%' or address like '%AVENUE%';

-- exercise2
select * 
from sql_store.customers
where phone like '9%';