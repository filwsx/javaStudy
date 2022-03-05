#承接《第11章_数据处理之增删改》的综合案例。
# 1、创建数据库test01_library
CREATE DATABASE IF NOT EXISTS test01_library CHARACTER SET 'utf8';

# 2、创建表 books，表结构如下：
/*
id 书编号INT
name 书名VARCHAR(50)
authors 作者VARCHAR(100)
price 价格FLOAT
pubdate 出版日期YEAR
note 说明VARCHAR(100)
num 库存INT
*/
CREATE TABLE books(
id  INT,
NAME VARCHAR(50),
AUTHORS VARCHAR(100),
price DECIMAL(10,2),
pubdate YEAR,
note VARCHAR(100),
num INT
);

# 3、使用ALTER语句给books按如下要求增加相应的约束
/*
字段名 字段说明 数据类型 主键 外键 非空 唯一 自增
id 书编号INT(11) 是否是是是
name 书名VARCHAR(50) 否否是否否
authors 作者VARCHAR(100) 否否是否否
price 价格FLOAT 否否是否否
pubdate 出版日期YEAR 否否是否否
note 说明VARCHAR(100) 否否否否否
num 库存INT(11) 否否是否否
*/
ALTER TABLE books
ADD CONSTRAINT pk_books_id PRIMARY KEY(id);

ALTER TABLE books
CHANGE id id INT(11) AUTO_INCREMENT;

#其他略