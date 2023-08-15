-- 演示自增长的使用
-- 创建表
CREATE TABLE t24
	(id INT PRIMARY KEY AUTO_INCREMENT,
	 email VARCHAR(32)NOT NULL DEFAULT '',
	 `name` VARCHAR(32)NOT NULL DEFAULT ''); 
DESC t24
-- 测试自增长的使用
-- 这样是第一种，就是将id设置为null，但是自增长会直接保存为1
INSERT INTO t24
	VALUES(NULL, 'tom@qq.com', 'tom');

-- 这是第二种，不设置id的值，自增长也会运行
INSERT INTO t24
	(email, `name`) VALUES('hsp@sohu.com', 'hsp');

SELECT * FROM t24;

-- 修改默认的自增长开始值
ALTER TABLE t25 AUTO_INCREMENT = 100
CREATE TABLE t25
	(id INT PRIMARY KEY AUTO_INCREMENT,
	 email VARCHAR(32)NOT NULL DEFAULT '',
	 `name` VARCHAR(32)NOT NULL DEFAULT ''); 
INSERT INTO t25
	VALUES(NULL, 'mary@qq.com', 'mary');
INSERT INTO t25
	VALUES(666, 'hsp@qq.com', 'hsp');
SELECT * FROM t25;

CREATE DATABASE tmp;
CREATE TABLE dept( /*部门表*/
deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0,
dname VARCHAR(20)  NOT NULL  DEFAULT "",
loc VARCHAR(13) NOT NULL DEFAULT ""
) ;

#创建表EMP雇员
CREATE TABLE emp
(empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, /*编号*/
ename VARCHAR(20) NOT NULL DEFAULT "", /*名字*/
job VARCHAR(9) NOT NULL DEFAULT "",/*工作*/
mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*上级编号*/
hiredate DATE NOT NULL,/*入职时间*/
sal DECIMAL(7,2)  NOT NULL,/*薪水*/
comm DECIMAL(7,2) NOT NULL,/*红利*/
deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
) ;

#工资级别表
CREATE TABLE salgrade
(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
losal DECIMAL(17,2)  NOT NULL,
hisal DECIMAL(17,2)  NOT NULL
);

#测试数据
INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);	


