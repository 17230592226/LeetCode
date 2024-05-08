# 题目

![image](https://github.com/17230592226/LeetCode/assets/57279736/82358c32-273d-454e-9c15-f1e8373840d3)
![image](https://github.com/17230592226/LeetCode/assets/57279736/fe33477e-5fcc-4270-a152-3b73e7895bf0)
# 代码
## 方法1 left join
```
# Write your MySQL query statement below
SELECT name AS 'Customers'
FROM Customers
LEFT JOIN Orders ON Customers.Id = Orders.CustomerId
WHERE Orders.CustomerId IS NULL
```

## 方法2 排除
```
# Write your MySQL query statement below
SELECT name AS 'Customers'
FROM Customers
where Customers.id  not in (
    select customerId from Orders
)
```
