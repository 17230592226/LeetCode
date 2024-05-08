# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/96b53389-d098-4b8e-ab5f-197637b28af1)

# 代码
```
select firstName,lastName,city,state from Person left join Address on Person.personID = Address.PersonID
```
# 解释
![image](https://github.com/17230592226/LeetCode/assets/57279736/e81fa593-fc06-4765-aa3d-da4008649707)

# 错误情况
```
# 错误语句
select firstName,lastName,city,state from Person,Address where Person.personID = Address.PersonID
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/0843d1f3-2c5e-485f-9307-2cf0c0b01e5c)
