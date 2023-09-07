-- 多表查询

-- 多表查询的等值连接

-- ?显示雇员名,雇员工资及所在部门的名字 【笛卡尔集】
-- 建议表起别名
/*
	1. 雇员名,雇员工资 来自 emp表
	2. 部门的名字 来自 dept表
	3. 需求对 emp 和 dept查询  ename,sal,dname,deptno
	4. 当我们需要指定显示某个表的列是，需要 表.列表
*/
SELECT ename,sal,dname,emp.deptno
	FROM emp, dept 
	WHERE emp.deptno = dept.deptno;
	

-- 多表查询的条件不能少于 表的个数-1, 否则会出现笛卡尔集
-- ?如何显示部门号为10的部门名、员工名和工资 
SELECT ename,sal,dname,emp.deptno
	FROM emp, dept 
	WHERE emp.deptno = dept.deptno and emp.deptno = 10;

-- ?显示各个员工的姓名，工资，及其工资的级别
-- 思路 姓名，工资 来自 emp 13
--      工资级别 salgrade 5
select ename, sal, grade 
	from emp , salgrade
	where sal between losal and hisal;


-- 多表查询的自连接

-- 思考题: 显示公司员工名字和他的上级的名字
-- 员工名字 在emp, 上级的名字 在emp
-- 员工和上级是通过 emp表的 mgr 列关联
-- 自连接的特点 1. 把同一张表当做两张表使用，它既是员工表，又是领导表
--            2. 需要给表取别名 表名  表别名
--		 	  3. 列名不明确，可以指定列的别名 列名 as 列的别名

-- 这个是92的缺点，结构不清晰，表的连接条件，和后期进一步筛选的条件，都放到了where的后面
SELECT worker.ename AS '职员名', boss.ename AS '上级名'
FROM emp worker, emp boss
WHERE worker.mgr = boss.empno;


-- MySQL 99的语法
-- 99的语法好的地方在于，如果我想要表连接之后，进一步筛选的条件，都放到了where后面
SELECT worker.ename AS '职员名', boss.ename AS '上级名'
FROM emp worker JOIN emp boss
ON worker.mgr = boss.empno;
-- 加这个ON的条件只是为了避免笛卡尔积现象，只是为了查询出有效的组合记录。
-- 匹配的次数一次都没有少，还是第一个表乘以第二个表的大小