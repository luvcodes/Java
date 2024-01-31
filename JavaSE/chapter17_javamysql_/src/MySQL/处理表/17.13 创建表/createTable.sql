-- CREATE TABLE table_name (
--     field 1 datatype,
--     field 2 datatype,
--     field 3 datatype
-- ) character set 字符集 collate 校对规则 engine 存储引擎
-- character set: 如不指定则为所在数据库字符集
-- collate: 如不指定则为所在数据库校对规则
# 指令创建表
CREATE TABLE `user` (
	id INT,
	`name` VARCHAR(255),
	`password` VARCHAR(255),
	`birthday` DATE
) CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB;

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