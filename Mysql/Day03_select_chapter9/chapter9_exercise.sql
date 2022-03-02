#1.查询和Zlotkey相同部门的员工姓名和工资
SELECT last_name,salary
FROM employees e
WHERE e.`department_id` IN (
	SELECT department_id
	FROM employees e2
	WHERE e2.`last_name` = 'Zlotkey'
	);

#2.查询工资比公司平均工资高的员工的员工号，姓名和工资。
SELECT job_id,last_name,salary
FROM employees
WHERE salary > ALL(
	SELECT AVG(salary)
	FROM employees
	);

#3.选择工资大于所有JOB_ID = 'SA_MAN'的员工的工资的员工的last_name, job_id, salary
SELECT last_name, job_id, salary
FROM employees
WHERE salary > ALL(
	SELECT salary
	FROM employees
	WHERE job_id = 'SA_MAN'
	);
#20220302 1557done

#4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
SELECT DISTINCT e2.last_name,e2.employee_id
FROM employees e1,employees e2
WHERE e1.last_name LIKE "%u%"
#AND e2.last_name LIKE "%u%"
AND e1.department_id = e2.department_id;
#20220302 1606 done

#5.查询在部门的location_id为1700的部门工作的员工的员工号
SELECT employee_id
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`location_id` = 1700;

#6.查询管理者是King的员工姓名和工资
SELECT e1.last_name,e1.salary
FROM employees e1
WHERE e1.`manager_id` IN (
	SELECT employee_id
	FROM employees e2
	WHERE e2.`last_name` = 'King'
	);

#7.查询工资最低的员工信息: last_name, salary
SELECT e1.last_name, e1.salary
FROM employees e1
WHERE salary = (
	SELECT MIN(e2.salary)
	FROM employees e2
	);
#20220302 1617done

#8.查询平均工资最低的部门信息
SELECT d.*
FROM departments d ,(
	SELECT AVG(e1.salary) dep_salary_avg ,department_id
	FROM employees e1
	GROUP BY department_id
	ORDER BY dep_salary_avg ASC
	LIMIT 0,1
) temp
WHERE d.`department_id` = temp.department_id;
#20220302 1640done 一上来就是这个思路，但是很混乱，花时间厘清和语法错误
#比如order by 内是否是可使用聚合函数AVG
#没意识到把内查询作为一个表来from，避免limit不能使用in

#9.查询平均工资最低的部门信息和该部门的平均工资（相关子查询）
#在8的基础上修改即可
SELECT d.*,AVG(e.salary)
FROM departments d ,(
	SELECT AVG(e1.salary) dep_salary_avg ,department_id
	FROM employees e1
	GROUP BY department_id
	ORDER BY dep_salary_avg ASC
	LIMIT 0,1
) temp,employees e
WHERE d.`department_id` = temp.department_id
AND e.`department_id` = d.`department_id`;

#10.查询平均工资最高的 job 信息
SELECT j.*
FROM jobs j , (
	SELECT AVG(salary) sal_by_jobid, job_id
	FROM employees
	GROUP BY job_id
	ORDER BY sal_by_jobid DESC
	LIMIT 0,1
	) temp
WHERE j.`job_id` = temp.job_id;

#11.查询平均工资高于公司平均工资的部门有哪些?
SELECT department_id,AVG(salary) avg_sal_by_dep
FROM employees
GROUP BY department_id
HAVING avg_sal_by_dep > (
	SELECT AVG(salary)
	FROM employees
	);
#where中无法使用avg_sal_by_dep，因为where比select先执行，而where中不能使用聚合函数
#20220302 1702

#12.查询出公司中所有 manager 的详细信息
SELECT DISTINCT mgr.employee_id,mgr.last_name,mgr.job_id,mgr.department_id
FROM employees emp JOIN employees mgr
ON emp.manager_id = mgr.employee_id;
#直接copy答案

#13.各个部门中 最高工资中最低的那个部门的 最低工资是多少?
SELECT MIN(e.salary)
FROM employees e,(SELECT department_id
	FROM employees
	GROUP BY department_id
	ORDER BY MAX(salary)
	LIMIT 0,1) temp
WHERE e.department_id = temp.department_id;

#14.查询平均工资最高的部门的 manager 的详细信息: last_name, department_id, email, salary
/*
SELECT e.`last_name`,e.`department_id`,e.`email`,e.`salary`
FROM employees e,(SELECT department_id
	FROM employees
	GROUP BY department_id
	ORDER BY MAX(salary)
	LIMIT 0,1) temp,departments d
WHERE e.department_id = temp.department_id
ANd d.`manager_id` = e.`employee_id`;
*/
SELECT last_name, department_id, email, salary
FROM employees
WHERE employee_id IN
(
SELECT DISTINCT manager_id
FROM employees e, (SELECT department_id
	FROM employees
	GROUP BY department_id
	ORDER BY AVG(salary) DESC
	LIMIT 0,1) temp
WHERE e.department_id = temp.department_id
);
#20220302 1727done 目前为止，做的最慢的一个

#15. 查询部门的部门号，其中不包括job_id是"ST_CLERK"的部门号

#16. 选择所有没有管理者的员工的last_name

#17．查询员工号、姓名、雇用时间、工资，其中员工的管理者为 'De Haan'

#18.查询各部门中工资比本部门平均工资高的员工的员工号, 姓名和工资（相关子查询）

#19.查询每个部门下的部门人数大于 5 的部门名称（相关子查询）

#20.查询每个国家下的部门个数大于 2 的国家编号（相关子查询）

#后记
#20道题目，最难的几道有：8、8为9/10/13的母题，11，14
