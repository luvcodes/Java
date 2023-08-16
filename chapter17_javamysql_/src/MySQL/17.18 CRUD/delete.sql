-- DELETE语句演示
DELETE FROM employee WHERE user_name = 'mark';
-- 删除表中所有记录
DELETE FROM `goods`;

-- DELETE语句不能删除某一列的值（可使用update 设为 null 或者 '')

-- 使用delete语句仅删除记录，不能删除表本身。如果要删除表本身
-- 使用drop TABLE employee

SELECT * FROM employee;
SELECT * FROM goods;