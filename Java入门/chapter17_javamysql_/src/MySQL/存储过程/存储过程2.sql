CREATE TABLE stud (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          age INT NOT NULL
);

INSERT INTO stud (name, age) VALUES ('John Doe', 20);
INSERT INTO stud (name, age) VALUES ('Jane Smith', 22);
INSERT INTO stud (name, age) VALUES ('Alice Johnson', 19);

-- 创建存储过程
DELIMITER //
CREATE PROCEDURE GetStudentAge()
BEGIN
    DECLARE student_age INT;  -- 声明变量

    SELECT age
    INTO student_age  -- 将查询结果赋值给变量
    FROM students
    WHERE name = 'John Doe';

    -- 这里可以使用变量student_age进行其他操作
    SELECT student_age;  -- 例如，我们可以选择它来查看值
END //
DELIMITER ;

CALL GetStudentAge();


