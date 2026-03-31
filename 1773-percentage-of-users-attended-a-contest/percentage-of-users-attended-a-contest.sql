# Write your MySQL query statement below
select contest_id , ROUND(COUNT(DISTINCT user_id) * 100.0 / 
          (SELECT COUNT(*) FROM Users), 2) AS percentage
from Register 
group by contest_id
ORDER BY percentage DESC,
contest_id;