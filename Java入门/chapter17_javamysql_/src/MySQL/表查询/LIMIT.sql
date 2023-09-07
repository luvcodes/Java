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

-- 分页
-- 每页显示3条记录
-- 第一页: limit 0, 3 [0,1,2]
-- 第二页: limit 3, 3 [3,4,5]
-- 第三页: limit 6, 3 [6,7,8]
-- 第四页: limit 9, 3 [9,10,11]
-- limit (pageNo - 1) * pageSize, pageSize