-- 多表查询的自连接
-- 思考题: 显示公司员工名字和他的上级的名字
-- 员工名字 在emp, 上级的名字 在emp
-- 员工和上级是通过 emp表的 mgr 列关联
-- 自连接的特点 1. 把同一张表当做两张表使用
--            2. 需要给表取别名 表名  表别名
--		 	  3. 列名不明确，可以指定列的别名 列名 as 列的别名
SELECT worker.ename AS '职员名', boss.ename AS '上级名'
	FROM emp worker, emp boss
	WHERE worker.mgr = boss.empno;
SELECT * FROM emp;