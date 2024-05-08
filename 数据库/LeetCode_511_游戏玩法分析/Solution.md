# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/ddf7dc10-99f2-4459-9e87-5d8a0756f419)
![image](https://github.com/17230592226/LeetCode/assets/57279736/268568db-9626-460e-9cae-17df8f58612a)
# 代码
##
```
#使用窗口函数 `FIRST_VALUE` 来获取每个 `player_id` 分组内的最早的 `event_date`,用于在每个分组中获取某个字段的第一个值。
#`PARTITION BY A.player_id` 指定根据 `player_id` 进行分组，`ORDER BY A.event_date` 指定按照 `event_date` 升序排序。
#`PARTITION BY`通常用于分区表（如哈希表）中，它根据一个或多个列的值将数据分配到不同的分区。这意味着数据按照特定的分区规则进行分组，而不是按照传统的行分组方式。分区表的优势在于可以提高查询性能，特别是在处理大量数据时。
#相比之下，`GROUP BY`是用于常规表中的分组操作。它根据一个或多个列的值将数据按照行进行分组，通常用于聚合函数（如SUM、COUNT等）的计算。在常规表中，`GROUP BY`语句将数据按照指定的列进行分组，并返回每个组的结果集。
#OVER` 后面跟着一个子句，这个子句定义了窗口函数如何对数据进行分区
select distinct player_id,first_value(event_date) over(
    partition by player_id
    order by event_date 
) as first_login
from Activity 
;
```
