CREATE TABLE t14 (
	birthday DATE,
	job_time DATETIME,
	login_time TIMESTAMP 
	NOT NULL DEFAULT CURRENT_TIMESTAMP 
	ON UPDATE CURRENT_TIMESTAMP
);
SELECT * FROM t14;
INSERT INTO t14(birthday, job_time) VALUES ('2022-11-11', '2022-11-11 10:10:10');
-- 如果我们更新 t14表的某条记录，login_time列会自动地以当前时间更新