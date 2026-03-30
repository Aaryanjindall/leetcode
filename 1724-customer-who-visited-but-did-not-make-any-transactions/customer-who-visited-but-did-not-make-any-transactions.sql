select customer_id, count(*) AS count_no_trans
from  Visits LEFT JOIN Transactions
ON Visits.visit_id = Transactions.visit_id 
where transaction_id IS NULL 
GROUP BY customer_id;