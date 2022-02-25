USE filwsxdb;
SELECT * FROM employees;

#中图：内连接 A∩B
SELECT employee_id,last_name,department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id;

# 两个表在连接过程中，除了返回满足连接条件的行以外，还返回左表中不满足条件的行，这种连接称为左外连接。
SELECT employee_id,last_name,department_name
#FROM employees e LEFT JOIN departments d 	#左上图：左外连接
FROM employees e RIGHT JOIN departments d 	#右上图：右外连接
ON e.`department_id` = d.`department_id`;

SELECT employee_id,last_name,department_name
#FROM employees e LEFT JOIN departments d 	#左中图：A - A∩B
FROM employees e RIGHT JOIN departments d 	#右中图：B - A∩B
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL

#左下图：满外连接
# 左中图 + 右上图  A∪B
SELECT employee_id,last_name,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL
UNION ALL  #没有去重操作，效率高
SELECT employee_id,last_name,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
#WHERE e.`department_id` IS null;	#取消注释后为右下图
					#左中图 + 右中图  A ∪B- A∩B 或者 (A -  A∩B) ∪ （B - A∩B）
