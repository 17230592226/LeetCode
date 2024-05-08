# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/781e0ef6-7e43-4993-b620-48e728e30f90)
![image](https://github.com/17230592226/LeetCode/assets/57279736/88c4d184-bc6e-4429-b0be-0147a32f450c)

# 代码
## 方法1 join
```
DELETE p1 
FROM Person p1 join Person p2
on p1.Email = p2.Email 
where p1.Id > p2.Id
```
## 方法2 where
```
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id
```
