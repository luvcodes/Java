# REPEAT ... UNTIL结构与LOOP结构的主要区别在于，
# REPEAT块中的代码至少会执行一次，然后才会检查UNTIL条件。而LOOP结构可能一次都不执行，如果其入口条件为FALSE。

CREATE TABLE employees (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           position VARCHAR(255) NOT NULL
);

INSERT INTO employees (name, position) VALUES
                                           ('John Doe', 'Software Engineer'),
                                           ('Jane Smith', 'Data Scientist'),
                                           ('Alice Johnson', 'Product Manager');


DELIMITER //

CREATE PROCEDURE ListEmployeesRepeat()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE emp_name VARCHAR(255);
    DECLARE emp_position VARCHAR(255);
    DECLARE cur CURSOR FOR SELECT name, position FROM employees;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

OPEN cur;

REPEAT
FETCH cur INTO emp_name, emp_position;
        IF NOT done THEN
            -- 这里，您可以对每个员工的数据进行操作。例如，打印他们的名字和职位:
SELECT emp_name, emp_position;
END IF;
    UNTIL done END REPEAT;

CLOSE cur;
END //

DELIMITER ;

CALL ListEmployeesRepeat();

