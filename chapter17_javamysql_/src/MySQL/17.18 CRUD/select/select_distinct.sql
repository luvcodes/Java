CREATE TABLE `student` (
    id INT NOT NULL DEFAULT 1,
    `name` VARCHAR(20) not NULL DEFAULT '',
    chinese FLOAT NOT NULL DEFAULT 0.0,
    english FLOAT NOT NULL DEFAULT 0.0,
    math FLOAT NOT NULL DEFAULT 0.0
);
DELETE FROM student;
INSERT INTO `student` (id, `name`, chinese, english, math)
VALUES (1, 'mark', 89, 90, 95);
INSERT INTO `student` (id, `name`, chinese, english, math)
VALUES (2, 'bill', 75, 75, 80);
INSERT INTO `student` (id, `name`, chinese, english, math)
VALUES (3, 'daisy', 89, 90, 95);
INSERT INTO `student` (id, `name`, chinese, english, math)
VALUES (4, 'chuck', 89, 91, 95);
INSERT INTO `student` (id, `name`, chinese, english, math)
VALUES (5, 'manny', 89, 92, 95);
INSERT INTO `student` (id, `name`, chinese, english, math)
VALUES (6, 'andrew', 89, 93, 95);
INSERT INTO `student` (id, `name`, chinese, english, math)
VALUES (7, 'Marvin', 89, 90, 95);

-- 查询表中所有学生的信息
SELECT * FROM student;
-- 查询表中所有学生的姓名和对应的英语成绩
SELECT `name`, english FROM student;
-- 过滤表中重复数据 DISTINCT
SELECT DISTINCT english FROM student -- SELECT DISTINCT `name`, english FROM student; -- 这样查出来的两列记录都要相同，才可以去重