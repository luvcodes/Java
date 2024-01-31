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

#     IF done THEN ... END IF;:
#     这是一个条件语句，用于检查 done 变量的值。
#     如果 done 的值为1，这意味着游标已经读取到了数据的末尾，没有更多的数据可以获取。
#     在这种情况下，LEAVE read_loop; 语句会被执行，它会退出 read_loop 循环。
#     这个条件语句是通过之前定义的 CONTINUE HANDLER 实现的，当游标读取到数据的末尾时，CONTINUE HANDLER 会设置 done 的值为1。

    # 'done'为什么会变成1呢？done的值又不增加？
#     定义了一个 CONTINUE HANDLER，它的作用是当某个特定的条件发生时执行一段代码。在这个例子中，这个特定的条件是 NOT FOUND，它表示当游标尝试获取更多的数据但没有找到时
#     （即，当游标已经读取到数据的末尾）。
#     当这个条件发生时，CONTINUE HANDLER 会执行其后的代码，即 SET done = 1;。这行代码将 done 变量的值设置为1。
#     因此，每次循环体中的 FETCH 语句尝试从游标中获取数据时，如果没有更多的数据可以获取（即，已经读取到数据的末尾），CONTINUE HANDLER 会被触发，done 的值会被设置为1。
#     然后，在循环体中的 IF done THEN ... END IF; 语句会检查 done 的值，如果它的值为1，循环会被退出。这就是如何确保循环只处理表中的数据，并在读取完所有数据后正确地结束。


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

