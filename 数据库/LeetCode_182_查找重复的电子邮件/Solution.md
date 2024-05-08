# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/6d5ef4a9-9170-4e35-b7e5-8f2f35b266fd)
![image](https://github.com/17230592226/LeetCode/assets/57279736/80374dac-c667-4949-a3a8-80e10092fc78)

# 代码
# 方法 1 使用 GROUP BY 和 HAVING 条件
```
select Email
from Person 
group by email
having count(email)>1
```
# 方法2 使用 GROUP BY 和临时表
```
select Email from
(
  select Email, count(Email) as num
  from Person
  group by Email
)
where num > 1
;
# 出错
#Every derived table must have its own alias （每个派生表都必须有自己的别名）
```

```
#正确
select Email
from (
    select email,count(email) as num
    from Person
    group by email
) as T
where num > 1
;
```
