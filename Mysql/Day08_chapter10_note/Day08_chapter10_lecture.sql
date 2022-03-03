#Chapter10_Create DataBase and manager it

USE filwsxdb;

#创建和管理数据库
CREATE DATABASE IF NOT EXISTS mytest CHARACTER SET 'GBK';

SHOW TABLES;

DROP DATABASE IF EXISTS mytest;

USE mytest;

SHOW CREATE DATABASE mytest;

#创建表
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

#修改表
#3.1 添加一个字段
ALTER TABLE myemp2
ADD anu_salary DOUBLE(10,2);

ALTER TABLE myempl
ADD email VARCHAR(40) FIRST;

ALTER TABLE myempl
ADD phone_number VARCHAR(20) AFTER emp_name;

#3.2 修改一个字段：数据类型、长度、默认值（略）

#3.3 重命名一个字段

#3.4 删除一个字段

#管理表
#4.1 重命名表

#4.2 删除表

#4.3 清空表

#5. DCL 中 COMMIT 和 ROLLBACK

#6. 对比 TRUNCATE TABLE 和 DELETE FROM 
