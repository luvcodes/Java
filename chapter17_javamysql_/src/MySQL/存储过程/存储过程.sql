CREATE TABLE students (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          age INT NOT NULL
);

-- 迄今为止，使用的大多数SQL语句都是针对一个或多个表的单条语句。
-- 并非所有操作都这么简单，经常会有一个完整的操作需要多条语句才能完成

-- 为什么要使用存储过程？通过把处理封装在容易使用的单元中，简化复杂的操作

-- 为什么要使用DELIMITER //
-- DELIMITER //告诉命令行实用程序使用//作为新的语句结束分隔符，可以看到标志存储过程结束的END定义为END//
-- 而不是END;。这样，存储过程体内的;仍然保持不动，并且正确地传递给数据库引擎。
-- DELIMITER //：这一命令将语句的结束符从默认的分号（;）改为双斜线（//）。
-- 这样，你可以在存储过程或函数的定义中使用分号，而不会结束整个定义。

DELIMITER //
CREATE PROCEDURE add_student(IN student_name VARCHAR(255), IN student_age INT)
BEGIN
INSERT INTO students (name, age) VALUES (student_name, student_age);
END //
DELIMITER ;

CALL add_student('John Doe', 20);

select * from students;