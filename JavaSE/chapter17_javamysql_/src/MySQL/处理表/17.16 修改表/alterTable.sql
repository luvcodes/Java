-- 修改表的操作练习

-- -- 添加列
-- ADD TABLE tablename (column datatype [DEFAULT expr], 
-- 	[, column datatype]...
-- );
-- -- 修改列
-- MODIFY TABLE tablename (column datatype [DEFAULT expr], 
-- 	[, column datatype]...
-- );
-- -- 删除列
-- DROP TABLE tablename (column);
-- -- 修改表名
-- RENAME table 表名 TO 新表名;
-- -- 修改表字符集
-- ALTER TABLE 表名 CHARACTER SET 字符集;

-- 员工表的emp上增加一个image列，varchar类型(要求在resume后面)
ALTER TABLE `emp` 
	ADD `image` VARCHAR(32) NOT NULL DEFAULT '' AFTER `resume`;
DESC `emp` -- 显示表结构，可以查看表的所有列

-- 修改job列，使其长度为60
ALTER TABLE `emp` MODIFY `job` VARCHAR (60) NOT NULL DEFAULT '';

-- 删除sex列
ALTER TABLE `emp` DROP `sex`;

-- 修改表名为employee
RENAME TABLE `emp` TO `employee`;
DESC `employee` -- 显示表结构，可以查看表的所有列

-- 修改表的字符集为utf8
ALTER TABLE `employee` CHARACTER SET utf8;

-- 列名name修改为user_name
ALTER TABLE `employee` CHANGE `name` `user_name` VARCHAR (32) NOT NULL DEFAULT '';
DESC `employee` -- 显示表结构，可以查看表的所有列