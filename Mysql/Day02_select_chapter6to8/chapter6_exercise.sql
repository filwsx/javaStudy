USE filwsxdb;
SELECT * FROM employees;
# 1.显示所有员工的姓名，部门号和部门名称。
SELECT e.last_name,e.department_id,d.department_name
FROM employees e,departments d
WHERE e.department_id = d.department_id;
#答案

# 2.查询90号部门员工的job_id和90号部门的location_id
SELECT e.last_name,e.department_id,l.location_id
FROM employees e,departments d,locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id;
#答案

# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
SELECT e.last_name,d.department_name,l.location_id,l.city
FROM employees e,departments d,locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
ORDER BY location_id;
#答案

# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name
SELECT e.last_name , e.job_id , e.department_id , d.department_name
FROM employees e,departments d,locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
AND l.city = 'Toronto';
#答案

# 5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为’Executive’
SELECT d.`department_name`,l.`street_address`,e.`last_name`,j.`job_title`,e.`salary`
FROM employees e, departments d,locations l,jobs j
WHERE e.`department_id` = d.`department_id`
AND d.`location_id` = l.`location_id`
AND e.`job_id` = j.`job_id`
AND d.`department_name` = 'Executive';
#答案

# 6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
SELECT e1.last_name employees,e1.job_id 'Emp#',e2.last_name manager,e2.job_id 'Mgr#'
FROM employees e1, employees e2
WHERE e1.manager_id = e2.employee_id;
#答案

# 7.查询哪些部门没有员工
SELECT department_name
FROM departments d, employees e
WHERE e.`department_id` = d.`department_id`
AND d.`department_id` IS NULL;	#结果错误！！
#答案

# 8.查询哪个城市没有部门
#不会！
#答案

# 9.查询部门名为 Sales 或 IT 的员工信息
SELECT e.`last_name`,d.`department_name`
FROM departments d, employees e
WHERE e.`department_id` = d.`department_id`
AND (d.`department_name` = 'Sales' OR d.`department_name` = 'IT');

#答案

