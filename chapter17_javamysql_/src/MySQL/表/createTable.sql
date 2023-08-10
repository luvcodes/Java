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