# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/b459b273-18c8-4ddf-8454-8e7c7682780e)

![image](https://github.com/17230592226/LeetCode/assets/57279736/6f2f4926-6b1f-4365-baa1-676cfde95690)

# 代码
``` left join
select a.name,b.bonus 
from Employee as a left join Bonus as b 
on a.empId = b.empId 
where b.bonus < 1000 or b.bonus is null
```
