#it is nothing to here.

#两倍速看完。
#先理解（构建知识体系与框架），记忆靠练习

#问题1：子表外键绑定父表复合主键约束可以吗，怎么做，有什么要求。20220305 1433
CREATE DATABASE dbtest13;

USE dbtest13;

SELECT * FROM information_schema.table_constraints 
WHERE table_name = 'dbtest13';

CREATE TABLE `user`(
id INT,
`NAME` VARCHAR(15),
`PASSWORD` VARCHAR(25),
PRIMARY KEY (`NAME`,`PASSWORD`)
);

CREATE TABLE user_info(
addr VARCHAR(50),
`NAME` VARCHAR(15),
`PASSWORD` VARCHAR(25),
CONSTRAINT fk_ui_id FOREIGN KEY (`NAME`,`PASSWORD`) REFERENCES `user`(`NAME`,`PASSWORD`)
#瞎蒙的复合约束的写法，竟然对了
);

SELECT * FROM `user`;

INSERT INTO `user`(id,`name`,`password`) VALUES 
(1,'Tom','123'),
(1,'Tom1','123'),
(1,'Tom','abc');

#成功
INSERT INTO `user_info`() VALUES
('承德','Tom','123'),
('衡水','Tom1','123'),
('国际庄','Tom','abc')

#失败！
INSERT INTO `user_info`() VALUES
('承德','Tom0','123');
#20220305 1450测试完成

#问题2：子表可以有几个外键
#这个有答案，我没仔细听。可以有多个外键约束。

#子表外键和子表主键在同一列，可否？
CREATE TABLE user2(
id INT,
`NAME` VARCHAR(15),
`PASSWORD` VARCHAR(25),
PRIMARY KEY (id)
);

CREATE TABLE user_info2(
id INT,
addr VARCHAR(50),
PRIMARY KEY (id),
CONSTRAINT fk_ui2_id FOREIGN KEY (id) REFERENCES user2(id)
);

INSERT INTO user2(id,`name`,`password`) VALUES 
(1,'Tom','123'),
(2,'Tom1','123'),
(3,'Tom','abc');

INSERT INTO user_info2(id,addr) VALUES 
(1,'NY'),
(2,'LA'),
(3,'湾区');

#失败！
INSERT INTO user_info2(id,addr) VALUES 
(0,'NY');

INSERT INTO user2(id,`name`,`password`) VALUES 
(0,'Tom','1230');

#成功
INSERT INTO user_info2(id,addr) VALUES 
(0,'NY');
#20220305 1505完成测试验证
DESC user_info2;
