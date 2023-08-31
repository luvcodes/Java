CREATE TABLE students (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          age INT NOT NULL
);

DELIMITER //
CREATE PROCEDURE add_student(IN student_name VARCHAR(255), IN student_age INT)
BEGIN
INSERT INTO students (name, age) VALUES (student_name, student_age);
END //
DELIMITER ;

CALL add_student('John Doe', 20);

select * from students;