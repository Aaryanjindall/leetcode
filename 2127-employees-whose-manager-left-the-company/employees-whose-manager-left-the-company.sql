select employee_id 
from Employees
where (salary < 30000 AND manager_id NOT IN (select employee_id from Employees))
Order by employee_id;