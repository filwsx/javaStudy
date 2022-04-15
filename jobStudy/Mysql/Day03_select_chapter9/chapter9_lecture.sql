USE filwsxdb;

#查询平均工资最低的部门id
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= ALL (SELECT AVG(salary)
		     FROM employees
		     GROUP BY department_id)
#自己写出 20220226 0906
#因为每个中间结果都是虚拟表，所以在我知道可以嵌套后，就想from子查询了
#并且猜测多行子查询就是from实现的

#题目：查询员工中工资大于本部门平均工资的员工的last_name,salary和其department_id
SELECT e1.last_name,e1.salary,e1.department_id
FROM employees e1
WHERE e1.salary > (SELECT AVG(salary)
		FROM employees e2
		WHERE e1.department_id = e2.department_id	#这里不能加;
		);	#20220302 1412done by myself

#题目：若employees表中employee_id与job_history表中employee_id相同的数目不小于2，
#输出这些相同id的员工的employee_id,last_name和其job_id
SELECT * FROM job_history;
SELECT e.employee_id,e.last_name,e.job_id
FROM employees e
WHERE 2 <= (
	SELECT COUNT(*)
	FROM job_history j
	WHERE e.employee_id = j.employee_id);
#20220302 1429 done by myself
