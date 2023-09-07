-- 子查询的演示
-- 请思考：如何显示与SMITH同一部门的所有员工?
/*
	1. 先查询到 SMITH的部门号得到
	2. 把上面的select 语句当做一个子查询来使用
*/
-- SELECT deptno 
-- 	FROM emp 
-- 	WHERE ename = 'SMITH'

-- 下面的答案.	
SELECT * 
	FROM emp
	WHERE deptno = (
		SELECT deptno 
		FROM emp 
		WHERE ename = 'SMITH'
	);

-- 课堂练习:如何查询和部门10的工作相同的雇员的
-- 名字、岗位、工资、部门号, 但是不含10号部门自己的雇员.
/*
	1. 查询到10号部门有哪些工作
	2. 把上面查询的结果当做子查询使用
*/
-- select distinct job 
-- 	from emp 
-- 	where deptno = 10;

--  下面语句完整
select ename, job, sal, deptno
	from emp
	where job in (
		SELECT DISTINCT job 
		FROM emp 
		WHERE deptno = 10
	) and deptno <> 10;


-- 在where子句可以使用子查询
-- 在from子句也可以使用子查询
-- from后面的子查询结果可以当做一张临时表
-- 案例: 找出诶个岗位的平均工资的薪资等级
-- 解决这个案例:
-- 第一步: 找出每个岗位的平均工资 (按照岗位分组求平均值)
SELECT job, avg(sal) as avgsal FROM emp GROUP BY job;
-- 第二部，八以上的查询结果当作一张真实存在的表t
SELECT t.*, s.grade
FROM
    (SELECT job, avg(sal) as avgsal FROM emp GROUP BY job) t
JOIN
    salgrade s
ON
    t.avgsal BETWEEN s.losal AND s.hisal;

-- 查询ecshop中各个类别中，价格最高的商品
-- 查询 商品表
-- 先得到 各个类别中，价格最高的商品 max + group by cat_id, 当做临时表

select goods_id, ecs_goods.cat_id, goods_name, shop_price
from (
         SELECT cat_id , MAX(shop_price) as max_price
         FROM ecs_goods
         GROUP BY cat_id
     ) temp , ecs_goods
where  temp.cat_id = ecs_goods.cat_id
  and temp.max_price = ecs_goods.shop_price;