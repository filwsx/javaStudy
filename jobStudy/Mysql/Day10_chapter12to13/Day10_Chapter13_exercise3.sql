#1. 创建数据库test04_company
CREATE DATABASE IF NOT EXISTS test04_company CHARACTER SET 'utf8';

#2. 按照下表给出的表结构在test04_company数据库中创建两个数据表offices和employees
#图略
USE test04_company;

CREATE TABLE offices(
officeCode INT(10) PRIMARY KEY AUTO_INCREMENT,
city VARCHAR(50) NOT NULL,
address VARCHAR(50),
country VARCHAR(50)NOT NULL,
postalCode VARCHAR(15) UNIQUE
);

CREATE TABLE employees(
employeeNumber INT PRIMARY KEY AUTO_INCREMENT,
lastName VARCHAR(50) NOT NULL,
firstName VARCHAR(50) NOT NULL,
mobile VARCHAR(25) UNIQUE,
officeCode INT(10) NOT NULL,
jobTitle VARCHAR(50) NOT NULL,
birth DATETIME NOT NULL,
note VARCHAR(255),
sex VARCHAR(5),
CONSTRAINT fk_emp_offcode FOREIGN KEY (officeCode) REFERENCES offices(officeCode)
);

#3. 将表employees的mobile字段修改到officeCode字段后面
ALTER TABLE employees
CHANGE mobile mobile VARCHAR(25) AFTER officeCode;

#4. 将表employees的birth字段改名为employee_birth
ALTER TABLE employees
CHANGE birth employee_birth DATETIME;

#5. 修改sex字段，数据类型为CHAR(1)，非空约束
ALTER TABLE employees
CHANGE sex sex CHAR(1) NOT NULL;

#6. 删除字段note
ALTER TABLE employees
DROP COLUMN note ;

#7. 增加字段名favoriate_activity，数据类型为VARCHAR(100)
ALTER TABLE employees
ADD favoriate_activity VARCHAR(100);

#8. 将表employees名称修改为employees_info
RENAME TABLE employees
TO employees_info;

