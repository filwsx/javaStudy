/*已经存在数据库test04_emp，两张表emp2和dept2*/
CREATE DATABASE test04_emp;
USE test04_emp;
CREATE TABLE emp2(
id INT,
emp_name VARCHAR(15)
);
CREATE TABLE dept2(
id INT,
dept_name VARCHAR(15)
);

#1.向表emp2的id列中添加PRIMARY KEY约束
ALTER TABLE emp2
ADD CONSTRAINT pk_emp2_id PRIMARY KEY (id);

#2.向表dept2的id列中添加PRIMARY KEY约束
ALTER TABLE dept2
ADD CONSTRAINT pk_dept2_id PRIMARY KEY (id);

#3.向表emp2中添加列dept_id，并在其中定义FOREIGN KEY约束，与之相关联的列是dept2表中的id列。
#alter table emp2 add dept_id int constraint fk_emp2_di foreign key (dept_id) references dept2(id);
#不能写在同一句
ALTER TABLE emp2
ADD dept_id INT;

ALTER TABLE emp2
ADD CONSTRAINT fk_emp2_di FOREIGN KEY (dept_id) REFERENCES dept2(id);

#基本是看着答案写完的，因为光看视频，没有跟着练习！ 20220305 1616