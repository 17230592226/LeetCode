# 题目

![image](https://github.com/17230592226/LeetCode/assets/57279736/17377dce-cd2a-4c95-be03-5a13d7de69cf)

![image](https://github.com/17230592226/LeetCode/assets/57279736/4b3cd59d-991a-44b7-b243-3a52fc729742)

# 代码
```
select customer_number 
from Orders
group by customer_number 
order by count(*) desc
limit 1
;
```
