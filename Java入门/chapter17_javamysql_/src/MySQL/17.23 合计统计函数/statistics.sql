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
SELECT SUM(math)
FROM student;
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