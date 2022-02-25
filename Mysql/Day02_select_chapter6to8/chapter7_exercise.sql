USE filwsxdb;
SELECT * FROM employees;

# 1.显示系统时间(注：日期+时间)
SELECT CURDATE() "日期",CURTIME() "时间"
FROM DUAL;

# 2.查询员工号，姓名，工资，以及工资提高百分之20%后的结果（new salary）
SELECT employee_id,last_name,salary,salary * 1.2 "new salary"
FROM employees;

# 3.将员工的姓名按首字母排序，并写出姓名的长度（length）
SELECT last_name , LENGTH(last_name) "length"
FROM employees
ORDER BY last_name;

# 4.查询员工id,last_name,salary，并作为一个列输出，别名为OUT_PUT
SELECT CONCAT(employee_id,last_name,salary) OUT_PUT
FROM employees;

# 5.查询公司各员工工作的年数、工作的天数，并按工作年数的降序排序
SELECT DATEDIFF(CURDATE(),hire_date) "hire_days",DATEDIFF(CURDATE(),hire_date) / 365 "hire_years"
FROM employees
ORDER BY hire_years DESC;

# 6.查询员工姓名，hire_date , department_id，满足以下条件：雇用时间在1997年之后，department_id为80 或 90 或110, commission_pct不为空
SELECT last_name,hire_date,department_id
FROM employees
WHERE DATEDIFF(STR_TO_DATE("1997-12-31", "%Y-%m-%d"),hire_date) > 0
AND department_id IN (80,9,110)
AND commission_pct IS NULL;

# 7.查询公司中入职超过10000天的员工姓名、入职时间
SELECT last_name,hire_date
FROM employees
WHERE DATEDIFF(CURDATE(),hire_date) > 10000;

# 8.做一个查询，产生下面的结果
# <last_name> earns <salary> monthly but wants <salary*3>
SELECT CONCAT(last_name," earns ",salary," monthly but wants ",salary*3) "Dream Salary"
FROM employees;

# 9.使用case-when，按照下面的条件：
#select e.last_name,e.job_id, CASE j.job_title WHEN 'AD_PRES' THEN 'A'
#	WHEN 'ST_MAN' THEN 'B'
#	WHEN 'IT_PROG' THEN 'C'
#	WHEN 'SA_REP' THEN 'D'
#	WHEN 'ST_CLERK'  THEN 'E'
#from employees e JOIN jobs j
#ON e.job_id = j.job_id;
#job_id不是数字！！！坑死我了

