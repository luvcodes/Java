CREATE TABLE `emp` (
	id INT,
	`name` VARCHAR(32),
	sex CHAR(1),
	birthday DATE,
	entry_date DATETIME,
	job VARCHAR(32),
	salary DOUBLE,
	resume TEXT 
);
-- 添加一条
INSERT INTO `emp` VALUES (100, 'test', '男', '2000-11-11', '2010-11-10 11:11:11', 'testing', 3000, 
'This is the work contents for the test guy of a testing job');

SELECT * FROM `emp`;