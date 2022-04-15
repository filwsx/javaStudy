# 1、创建数据库test03_company
CREATE DATABASE IF NOT EXISTS test03_company CHARACTER SET 'utf8';

# 2、创建表offices
/*officeCode int
city varchar(30)
address varchar(50)
country varchar(50)
postalCode varchar(25)
*/
USE test03_company;
CREATE TABLE offices(
officeCode INT,
city VARCHAR(30),
address VARCHAR(50),
country VARCHAR(50),
postalCode VARCHAR(25)
);

# 3、创建表employees
CREATE TABLE employees
AS SELECT *
FROM filwsxdb.`employees`;

DROP TABLE IF EXISTS employees;

/*
empNum int
lastName varchar(50)
firstName varchar(50)
mobile varchar(25)
code int
jobTitle varchar(50)
birth date
note varchar(255)
sex varchar(5)
*/
CREATE TABLE employees(
empNum INT,
lastName VARCHAR(50),
firstName VARCHAR(50),
mobile VARCHAR(25),
CODE INT,
jobTitle VARCHAR(50),
birth DATE,
note VARCHAR(255),
sex VARCHAR(5)
);

# 4、将表employees的mobile字段修改到code字段后面
ALTER TABLE employees
CHANGE mobile mobile VARCHAR(25) AFTER `code`;

# 5、将表employees的birth字段改名为birthday
ALTER TABLE employees
CHANGE birth birthday DATE;

# 6、修改sex字段，数据类型为char(1)
ALTER TABLE employees
CHANGE sex sex CHAR(1);

# 7、删除字段note
ALTER TABLE employees
DROP COLUMN note;

# 8、增加字段名favoriate_activity，数据类型为varchar(100)
ALTER TABLE employees
ADD favoriate_activity VARCHAR(100);

# 9、将表employees的名称修改为 employees_info
RENAME TABLE employees TO employees_info;

#该练习不写了，没意思。20220303 1625
#20220304 1339done 这个练习放在今天算是复习，昨天做确实有点无意义了，题目太多了！
