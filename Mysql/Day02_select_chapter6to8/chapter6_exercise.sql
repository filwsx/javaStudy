USE filwsxdb;
SELECT * FROM employees;
# 1.显示所有员工的姓名，部门号和部门名称。
# 2.查询90号部门员工的job_id和90号部门的location_id
# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name
# 5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为’Executive’
# 6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
employees Emp# manager Mgr#
kochhar 101 king 100
# 7.查询哪些部门没有员工
# 8. 查询哪个城市没有部门
# 9. 查询部门名为 Sales 或 IT 的员工信息