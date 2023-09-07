-- 合并查询
-- union的效率要高一些。对于表连接来说，每连接一次新表，则匹配的次数满足笛卡尔积，成倍翻
-- 但是union可以减少匹配的次数。在减少匹配次数的情况下，还可以完成两个结果集的拼接。
SELECT ename,sal,job FROM emp WHERE sal>2500; -- 5

SELECT ename,sal,job FROM emp WHERE job='MANAGER'; -- 3

-- union all 就是将两个查询结果合并，不会去重
SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
UNION ALL
SELECT ename,sal,job FROM emp WHERE job='MANAGER'; -- 3

-- union  就是将两个查询结果合并，会去重
SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
UNION 
SELECT ename,sal,job FROM emp WHERE job='MANAGER'; -- 3

-- union使用的注意事项
-- union在进行结果集合并的时候，要求两个结果集的列数相同
-- 要求结果集合并时和列的数据类型也需要相同