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