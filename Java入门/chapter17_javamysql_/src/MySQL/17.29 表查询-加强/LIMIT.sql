USE sql_store;

-- 6, 3 表示跳过前6个，取第7~9个，6是偏移量
SELECT * FROM emp
LIMIT 6,3;

SELECT * FROM emp
LIMIT 3;

SELECT * FROM emp
LIMIT 300;

SELECT * FROM emp
(where)
order by empno desc
limit 3;


select * from emp;