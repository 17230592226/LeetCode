# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/79c3bb0f-966b-4144-967f-2548fc65465a)

![image](https://github.com/17230592226/LeetCode/assets/57279736/0873994c-40b4-4568-9ef5-3de5a0ee04c6)

# 代码
## 方法1，使用where语句
```
#笛卡尔乘积
select a.name as Employee
from Employee as a,Employee as b
where a.managerId =b.id and a.salary > b.salary
```
## 方法2，使用join语句
```
select a.name as Employee
from Employee as a join Employee as b
on a.managerId=b.id and/where(这里都行) a.salary>b.salary
```
