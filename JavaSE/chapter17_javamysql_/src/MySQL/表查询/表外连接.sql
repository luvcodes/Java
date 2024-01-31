-- 外连接
-- 比如：列出部门名称和这些部门的员工名称和工作，
-- 同时要求 显示出那些没有员工的部门。
SELECT dname, ename, job 
	FROM emp, dept
	WHERE emp.deptno = dept.deptno
	ORDER BY dname;


-- 使用左连接
-- 意思就是相当于我想把stu所有的成绩都显示出来，即使在exam中没有相等的id匹配
-- （显示所有人的成绩，如果没有成绩，也要显示该人的姓名和id号,成绩显示为空）
-- 改成左外连接
SELECT `name`, stu.id, grade
	FROM stu LEFT JOIN exam
	ON stu.id = exam.id;

-- 使用右外连接（显示所有成绩，如果没有名字匹配，显示空)
-- 即：右边的表(exam) 和左表没有匹配的记录，也会把右表的记录显示出来
-- right代表什么: 表示将join关键字右边的这张表看成主表，主要是为了将
-- 这张表的数据全部查询出来，捎带着关联查询左边的表
-- 在外连接当中，两张表连接，产生了主次关系
SELECT `name`, stu.id, grade
	FROM stu RIGHT JOIN exam
	ON stu.id = exam.id;

-- 列出部门名称和这些部门的员工信息(名字和工作)，
-- 同时列出那些没有员工的部门名。
-- 使用左外连接实现
SELECT dname, ename, job
	FROM dept LEFT JOIN emp
	ON dept.deptno = emp.deptno;
	
-- 使用右外连接实现
SELECT dname, ename, job
	FROM emp RIGHT JOIN dept
	ON dept.deptno = emp.deptno;


-- 找出每个部门名称以及工资等级
-- 要求显示员工名、部门名、薪资、薪资等级
SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e
JOIN dept d
    ON e.deptno = d.deptno
JOIN salgrade s
    ON e.sal BETWEEN s.losal AND s.hisal;

-- 找出每个员工的部门名称以及工资等级，还有上级领导
-- 要求显示员工名、领导名、部门名、薪资、薪资等级
SELECT e.ename, e.mgr, d.dname, e.sal, s.grade
FROM emp e
JOIN dept d
     ON e.deptno = d.deptno
JOIN salgrade s
     ON e.sal BETWEEN s.losal AND s.hisal
-- 这里应该用左外连接，就不会丢失KING那一条NULL的数据了
LEFT JOIN emp leader
    ON e.mgr = leader.empno;

SELECT * FROM emp;