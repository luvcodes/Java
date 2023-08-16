-- 演示字符串类型的使用细节
-- char(4) varchar(4) 表示的是字符，而不是字节
-- CHAR(4)是定长(固定的大小), 就是说，即使你插入'aa', 也会占用分配4个字符的空间。
-- VARCHAR(4) 是变长(变化的大小), 就是说，如果你插入了'aa'，实际占用空间大小
-- 并不是4个字符，而是按照实际占用空间来分配(VARCHAR本身还需要占用1-3个字节来记录存放内容长度)
-- L(实际数据大小) + (1-3)字节
-- 什么时候使用char，什么时候使用varchar
-- 1. 如果数据是定长，推荐使用char，查询速度快
-- 2. 如果一个字段的长度是不确定，我们使用varchar
-- 在存放文本时，也可以使用Text数据类型，注意Text不能有默认值
CREATE TABLE t11 (`name` CHAR(4));
INSERT INTO t11
VALUES ('ryan');
INSERT INTO t11
VALUES ('你好啊呀');
SELECT *
FROM t11;
CREATE TABLE t12 (`name` VARCHAR(4));
INSERT INTO t12
VALUES ('ryan');
INSERT INTO t12
VALUES ('ab北京');
SELECT *
FROM t12;
-- 如果varchar不够用，可以考虑使用mediumtext或者longtext，
-- 如果想简单点，可以直接使用text
CREATE TABLE t13 (
    content TEXT,
    content2 MEDIUMTEXT,
    content3 LONGTEXT
);
INSERT INTO t13
VALUES ('今天天气好', '今天天气好好', '今天天气好好好');