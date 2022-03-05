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