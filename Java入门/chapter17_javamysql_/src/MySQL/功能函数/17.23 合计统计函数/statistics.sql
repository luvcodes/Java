-- 分组函数在使用的时候必须先进性分组，然后才能用
-- 如果没有对数据进行分组，整张表默认为一组

-- 分组函数在使用的时候需要注意哪些？
-- 1. 分组函数自动忽略NULL，不需要提前对NULL进行处理
-- 2. COUNT(具体字段): 表示统计该字段下所有不为NULL的元素的总数
--    COUNT(*): 统计表当中的总行数 (只要有一行数据count则++)

-- 3. 分组函数不能够直接使用在where子句中？
--    为什么在select语句中使用分组函数这样是可以的呢? select max(invoice_total) from sql_invoicing.invoices;
--    书写顺序是select -> from -> where -> group by -> order by
--    因为执行顺序是from -> where -> group by -> select -> order by
--    所以执行select语句中的分组函数是已经在group by执行完成之后才执行的
--    select ename, sal from emp where sal > min(sal); -- 这样是不行的
--    分组函数不能在where子句中执行，因为where子句的执行是先于group by子句的

-- 重点结论: 在一条select语句中，如果有group by语句的话，select后面只能跟: 参加分组的字段，以及分组函数。其他的一律不能跟。



-- 合计/统计函数 - count
-- 统计一个班级共有多少学生?
SELECT COUNT(*) FROM student;

-- 统计数学成绩大于90的学生有多少个？
SELECT COUNT(*) FROM student WHERE math > 90;

-- 统计总分大于250的人数有多少
SELECT COUNT(*) FROM student WHERE (math + english + chinese) > 250;

-- count(*)和count(列)的区别
-- 解释: count(*) 返回满足条件的记录的行数
-- count(列): 统计满足条件的某列有多少个，但是会排除为null
CREATE TABLE t15 (`name` VARCHAR(20));

INSERT INTO t15 VALUES ('tom');
INSERT INTO t15 VALUES ('jack');
INSERT INTO t15 VALUES ('mary');
-- INSERT INTO t15 VALUES (''); -- 空字符串也会包括进count(*)的统计，也会包括进count(`name`)里
INSERT INTO t15 VALUES (NULL);

SELECT * FROM t15;

SELECT COUNT(*) FROM t15;
-- 4 所有记录只有4条
SELECT COUNT(`name`) FROM t15;
-- 3 排除是null的那一条
-- 演示sum函数的使用
-- 统计一个班级数学总成绩
SELECT SUM(math) FROM student;

-- 统计一个班级语文、英语、数学各科的总成绩
SELECT SUM(math) AS math_total_score,
    SUM(english),
    SUM(chinese)
FROM student;

-- 统计一个班级语文、英语、数学的成绩总和
SELECT SUM(english + chinese + math)
FROM student;

-- 统计一个班级语文成绩平均分
SELECT SUM(chinese) / COUNT(*)
FROM student;

-- 注意事项: sum仅对数值起作用，否则就没有意义了。
-- 多列求和
SELECT SUM(math) AS math_total_score,
    SUM(english),
    SUM(chinese)
FROM student;

-- 合计函数 AVG
-- 求一个班级数学平均分?
SELECT AVG(math)
FROM student;
-- 求一个班级总分平均分？
SELECT AVG(math + chinese + english)
FROM student;

-- max/min
-- 求班级最高分和最低分 (数值)
SELECT MAX(math + english + chinese),
    MIN(math + english + chinese)
FROM student;

-- 求出班级数学最高分和最低分
SELECT MAX(math) AS math_high_score,
    MIN(math) AS math_min_score
FROM student;