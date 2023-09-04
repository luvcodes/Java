-- SELECT 语句
SELECT * FROM student WHERE `name` = 'daisy';
-- 查询英语成绩大于90分的同学
SELECT * FROM student WHERE english > 90;
-- 查询总分大于200分的同学
SELECT * FROM student WHERE (chinese + english + math) > 200;

-- 查询math大于60并且id大于4的学生成绩
SELECT * FROM student WHERE math > 60 AND id > 4;

-- 查询英语成绩大于语文成绩的同学
SELECT * FROM student WHERE english > math;

-- 查询总分大于200分 并且 数学成绩小于语文成绩的姓mark的学生
SELECT * FROM student WHERE (chinese + math + english) > 200 AND math < chinese AND `name` LIKE 'm%';

-- 练习
-- 查询英语分数在80 - 90之间
SELECT * FROM student WHERE english BETWEEN 80 AND 90;
-- 查询数学分数为89，90，91的同学
SELECT * FROM student WHERE math IN (89,90,91);
-- 查询所有姓李的学生成绩
SELECT * FROM student WHERE `name` LIKE '李%';
-- 查询数学分 > 80, 语文分 > 80的同学
SELECT * FROM student WHERE math > 80 AND chinese > 80;

-- 查询语文分数在70 - 80之间的同学
SELECT * FROM student WHERE chinese BETWEEN 80 AND 90;
-- 查询总分为189，190，191的同学
SELECT * FROM student WHERE (chinese + math + english) IN (189, 190, 191);
-- 查询所有姓李 或者 姓宋的学生成绩
SELECT * FROM student WHERE `name` LIKE '李%' OR `name` LIKE '宋%';
-- 查询数学比语文多30分的同学
SELECT * FROM student WHERE (math - chinese) >= 30;