# 题目
70. 爬楼梯
已解答
简单
相关标签
相关企业
提示
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
![image](https://github.com/17230592226/LeetCode/assets/57279736/4603a10e-ab0d-435a-92e3-191bef4cd68e)
# 代码
## go
```
func climbStairs(n int) int {
    p,q,r:=0,0,1
    for i:=1;i<=n;i++{
        p=q
        q=r
        r=p+q
    }
    return r
}
```
## 复杂度
- 时间复杂度：O(n)
- 空间复杂度：O(1)
