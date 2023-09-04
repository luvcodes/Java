-- 演示整型的使用
-- 使用TINYINT来演示范围，有符号 -128 - 127	如果没有符号 0 - 255
-- 表的字符集，校验规则，存储引擎，使用默认(也就是这个table所在的db是什么)
-- 1. 如果没有指定unsigned，则TINYINT就是有符号
-- 2. 如果指定unsigned，则TINYINT就是无符号 0 - 255


-- CREATE TABLE `t3` ( id TINYINT );
CREATE TABLE `t3` ( id TINYINT UNSIGNED);
INSERT INTO `t3`
VALUES
	( 127 );
SELECT
	* 
FROM
	t3;
	
	INSERT INTO `t3`
VALUES
	( 0 );