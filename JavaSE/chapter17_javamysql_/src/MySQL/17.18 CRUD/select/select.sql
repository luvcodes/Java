-- SELECT 语句的使用
-- 统计每个学生的总分
SELECT `name`, (chinese + english + math) FROM student;
-- 再所有学生总分加10分
SELECT `name`, (chinese + english + math + 10) FROM student;
-- 使用别名表示学生分数
SELECT `name` AS Name, (chinese + english + math + 10) AS total_score FROM student;

