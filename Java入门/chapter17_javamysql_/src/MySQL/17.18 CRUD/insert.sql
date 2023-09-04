-- 练习insert 语句
CREATE TABLE `goods` (
    id INT,
    goods_name VARCHAR(10),
    price DOUBLE
);
-- 添加数据
INSERT INTO `goods` (id, goods_name, price) VALUES (10, '华为手机', 2000);
INSERT INTO `goods` (id, goods_name, price) VALUES (20, '苹果手机', 3000);
DESC goods;
SELECT * FROM goods;