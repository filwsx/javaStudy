#Chapter10_Create DataBase and manager it

USE filwsxdb;

CREATE DATABASE IF NOT EXISTS mytest CHARACTER SET 'GBK';

SHOW TABLES;

DROP DATABASE IF EXISTS mytest;

USE mytest;

SHOW CREATE DATABASE mytest;

CREATE TABLE IF NOT EXISTS myempl(
id INT,
emp_name VARCHAR(15),
hire_date DATE
);

#创建表的方式二:富二代
CREATE TABLE myemp2
AS
#AS 后跟select语句，相当于复制表了
#若使用别名，复制的表字段为别名
SELECT * FROM filwsxdb.`employees`;

