-- 演示update语句
-- 将employee表中的记录修改
-- 1. 将所有员工薪水修改为5000元。[如果没有带where条件，会修改所有的记录，要小心]
UPDATE employee
SET salary = 5000;
-- 2. 将姓名为mark的员工薪水修改为3000元
UPDATE employee
SET salary = 3000
WHERE user_name = 'mark';
-- 3. 将jack的薪水在原有基础上增加1000元
INSERT INTO employee
VALUES (
        200,
        'jack',
        '1990-11-11',
        '2020-11-11 10:10:10',
        '捶背的',
        5000,
        '给大王捶背',
        'C:\\a.jpg'
    );
UPDATE employee
SET salary = salary + 100
WHERE user_name = 'jack';
SELECT *
FROM employee;
-- UPDATE语句可以用新值更新原有表行中的各列
-- SET语句指示要修改哪些列和要给予哪些值
-- WHERE语句指定应更新哪些行。如没有where语句，则更新所有行(记录)。
-- 如果需要修改多个字段
UPDATE employee
SET salary = salary + 100,
    job = '出主意的'
WHERE user_name = 'jack';