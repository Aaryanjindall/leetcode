# Write your MySQL query statement below
select name,bonus 
from Employee LEFT JOIN Bonus
ON Employee.empId = Bonus.empId 
where (bonus < 1000 OR bonus IS NULL);
