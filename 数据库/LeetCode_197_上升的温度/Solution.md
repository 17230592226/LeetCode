# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/860fae61-7740-4185-83d8-407faea0c6f3)
![image](https://github.com/17230592226/LeetCode/assets/57279736/698cdb81-13ca-4761-a530-da250a636b8c)

# 代码
## 方法1 where 笛卡尔积
```
select a.id
from Weather as a ,Weather as b
where datediff(a.recordDate ,b.recordDate ) =1 and a.Temperature >b.Temperature 
```

## 方法2 join 把方法1 中的逗号改成join
```
# Write your MySQL query statement below
select a.id
from Weather as a join Weather as b
where datediff(a.recordDate ,b.recordDate ) =1 and a.Temperature >b.Temperature 

```
