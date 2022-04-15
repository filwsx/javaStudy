# 1. 使用现有数据库dbtest11
USE bdtest11;

# 2. 创建表格pet
/*
name 宠物名称VARCHAR(20)
owner 宠物主人VARCHAR(20)
species 种类VARCHAR(20)
sex 性别CHAR(1)
birth 出生日期YEAR
death 死亡日期YEAR
*/
CREATE TABLE pet(
`name` VARCHAR(20),
`owner` VARCHAR(20),
species VARCHAR(20),
sex CHAR(1),
birth YEAR,
death YEAR
);

#3. 添加记录
/*
name owner species sex birth death
Fluffy harold Cat f 2003 2010
Claws gwen Cat m 2004
Buffy Dog f 2009
Fang benny Dog m 2000
bowser diane Dog m 2003 2009
Chirpy Bird f 2008
*/
INSERT INTO pet(`name`,`owner`,species,sex,birth,death) VALUES
('Fluffy','harold','Cat','f','2013','2010'),
('Claws','gwen','Cat','m','2014',NULL),
('Buffy',NULL,'Dog','f','2009',NULL),
('Fang','benny','Dog','m','2000',NULL),
('bowser','diane','Dog','m','2003','2009'),
('Chirpy',NULL,'Bird','f','2008',NULL);

# 4. 添加字段:主人的生日owner_birth DATE类型。
ALTER TABLE pet
ADD owner_birth DATE;

# 5. 将名称为Claws的猫的主人改为kevin
UPDATE pet
SET `owner` = 'kevin'
WHERE `name` = 'Claws'
AND species = 'cat';

# 6. 将没有死的狗的主人改为duck
UPDATE pet SET `owner` = 'duck' WHERE species='Dog' AND death IS NULL;

# 7. 查询没有主人的宠物的名字；
SELECT * FROM pet WHERE `owner` IS NULL;

# 8. 查询已经死了的cat的姓名，主人，以及去世时间；
SELECT * FROM pet WHERE species='cat' AND death IS NOT NULL;

# 9. 删除已经死亡的狗
DELETE FROM pet WHERE death IS NOT NULL AND species = 'dog';

# 10. 查询所有宠物信息
SELECT * FROM pet;

#so easy!