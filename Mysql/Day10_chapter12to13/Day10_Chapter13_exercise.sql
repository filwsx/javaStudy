/*已经存在数据库test04_emp，两张表emp2和dept2
CREATE DATABASE test04_emp;
use test04_emp;
CREATE TABLE emp2(
id INT,
emp_name VARCHAR(15)
);
CREATE TABLE dept2(
id INT,
dept_name VARCHAR(15)
);
*/
#1.向表emp2的id列中添加PRIMARY KEY约束


#2.向表dept2的id列中添加PRIMARY KEY约束


#3.向表emp2中添加列dept_id，并在其中定义FOREIGN KEY约束，与之相关联的列是dept2表中的id列。