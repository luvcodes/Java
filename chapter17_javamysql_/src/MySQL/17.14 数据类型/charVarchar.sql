-- 演示字符串类型使用char VARCHAR
-- CHAR(size)
-- 固定长度字符串 最大255字符
-- VARCHAR(size) 0 - 65535字节
-- 可变长度字符串 最大65532字节
-- 如果表的编码是 utf8 varchar(size) size = (65535-3) / 3 = 21844字符	1-3个字节用于记录大小

CREATE TABLE t09 (
		`name` CHAR(255)
);

CREATE TABLE t10 (
		`name` VARCHAR(21844)
);