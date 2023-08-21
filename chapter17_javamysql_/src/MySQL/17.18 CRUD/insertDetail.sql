-- 说明insert语句的细节
-- 1. 插入的数据应与字段的数据类型相同
-- 		比如 把'abc'添加到int类型会错误
INSERT INTO `goods` (id, goods_name, price) VALUES ('mark', '小米手机', 2000);
-- 2. 数据的长度应在列的规定范围内，
INSERT INTO `goods` (id, goods_name, price) VALUES (40, 'vivo手机vivo手机vivo手机vivo手机vivo手机vivo手机vivo手机', 3000);
-- 3. 在values中列出的数据位置必须与被加入的列的排列位置相对应
INSERT INTO `goods` (id, goods_name, price) VALUES ('vivo手机', 40, 2000);
-- 4. 字符和日期型数据应包含在单引号中
INSERT INTO `goods` (id, goods_name, price) 
	VALUES (40, 'vivo手机', 3000); -- 例如vivo手机没有引号
-- 5. 列可以是插入空值[前提是该字段允许为空]
INSERT INTO `goods` (id, goods_name, price) VALUES (40, 'vivo手机', NULL);
-- 6. 添加多条记录
INSERT INTO `goods` (id, goods_name, price) VALUES (40, 'vivo手机', 3000), (60, '海尔手机', 1800);
-- 7. 如果是给表中的所有字段添加数据，可以不写前面的字段名称
INSERT INTO `goods`	VALUES (70, 'IBM手机', 5000);
-- 8.默认值的使用，当不给某个字段值时，如果有默认值就会添加，否则报错
-- 	 如果某个列 没有指定 not null，那么当添加数据时，没有给定值，则会默认给null
INSERT INTO `goods` (id, goods_name) VALUES (40, 'vivo手机');

SELECT * FROM goods;