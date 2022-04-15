# 1. 使用已有的数据库dbtest11
USE dbtest11;

# 2. 创建表employee，并添加记录
/*
id name sex tel addr salary
10001 张一一男13456789000 山东青岛1001.58
10002 刘小红女13454319000 河北保定1201.21
10003 李四男0751-1234567 广东佛山1004.11
10004 刘小强男0755-5555555 广东深圳1501.23
10005 王艳女020-1232133 广东广州1405.16
*/
CREATE TABLE employee(
id INT,
`name` VARCHAR(5),
sex CHAR(1),
tel VARCHAR(20),
addr VARCHAR(40),
salary DOUBLE(10,2)
);
INSERT INTO employee (id,`name`,sex,tel,addr,salary) VALUES
(10001,'张一一','男','13456789000','山东青岛',1001.58),
(10002,'刘小红','女','13454319000','河北保定',1201.21),
(10003,'李四','男','0751-1234567','广东佛山',1004.11),
(10004,'刘小强','男','0755-5555555','广东深圳',1501.23),
(10005,'王艳','男','020-1232133','广东广州',1405.16);

# 3. 查询出薪资在1200~1300之间的员工信息。
SELECT * FROM employee WHERE salary > 1200 AND salary < 1300;
#答案
SELECT * FROM employee WHERE salary BETWEEN 1200 AND 1300;

# 4. 查询出姓“刘”的员工的工号，姓名，家庭住址。
SELECT * FROM employee WHERE `name` LIKE '刘%';

# 5. 将“李四”的家庭住址改为“广东韶关”
UPDATE employee SET addr = '广东韶关' WHERE `name` = '李四';

# 6. 查询出名字中带“小”的员工
SELECT * FROM employee WHERE `name` LIKE '%小%';

#so easy!
