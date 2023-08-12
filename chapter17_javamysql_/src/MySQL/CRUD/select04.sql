-- 演示order by使用
-- 对数学成绩排序后输出 【升序】
SELECT *
FROM student
ORDER BY math;
-- 对总分按从高到低的顺序输出 【降序】 -- 使用别名排序
SELECT `name`,
    (chinese + math + english) AS total_score
FROM student
ORDER BY total_score DESC;
-- 对姓李的学生成绩[总分]排序[升序]
SELECT `name`,
    (chinese + math + english) AS total_score
FROM student
WHERE `name` LIKE '李%'
ORDER BY total_score;
-- select `name`, (chinese + math + english) as total_score from student where `name` like '李%' order by (chinese + math + english);
-- select * from student where `name` like '李%' order by (chinese + math + english); -- 这样会显示三门课的三列，而不是显示一列总数