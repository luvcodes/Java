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

CREATE PROCEDURE ListEmployeesConcat()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE emp_name VARCHAR(255);
    DECLARE emp_position VARCHAR(255);
    DECLARE output TEXT DEFAULT '';
    DECLARE cur CURSOR FOR SELECT name, position FROM employees;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO emp_name, emp_position;
        IF done THEN
            LEAVE read_loop;
        END IF;
        -- 连接每个员工的名字和职位到输出字符串
        SET output = CONCAT(output, emp_name, ' - ', emp_position, '\n');
    END LOOP;

    CLOSE cur;
    -- 输出连接后的字符串
    SELECT output AS EmployeesList;
END //

DELIMITER ;

CALL ListEmployees();

