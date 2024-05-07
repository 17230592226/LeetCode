# 题解
给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

请你计算并返回达到楼梯顶部的最低花费。

 ![image](https://github.com/17230592226/LeetCode/assets/57279736/ae008375-6372-48b4-b601-ad2895e9aaef)

# 代码
## go
```
func minCostClimbingStairs(cost []int) int {
    n:=len(cost)
    dp:=make([]int,n+1)
//dp[0],dp[1]=0
    for i:=2;i<=n;i++{
        dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    }
    return dp[n]
}
```
## 复杂度
- 时间复杂度：O(n)
- 空间复杂度：O(n)

## go 滚动数组1 空间复杂度缩小到O(1)
```
func minCostClimbingStairs(cost []int) int {
    n:=len(cost)
    p,q,r:=0,0,0
    for i:=2;i<=n;i++{
        p=q
        q=r
        r=min(q+cost[i-1], p+cost[i-2])
        
    }
    return r
}
```
## go 滚动数组2 空间复杂度缩小到O(1)
```
func minCostClimbingStairs(cost []int) int {
    n:=len(cost)
    pre, cur := 0, 0
    for i := 2; i <= n; i++ {
        pre, cur = cur, min(cur+cost[i-1], pre+cost[i-2])
    }
    return cur

}
```
## go 滚动数组3 空间复杂度缩小到O(1)
```
func minCostClimbingStairs(cost []int) int {
    n:=len(cost)
    pre, cur := 0, 0
    for i := 2; i <= n; i++ {
        next := min(cur+cost[i-1], pre+cost[i-2])
        pre=cur
        cur=next
    }
    return cur

}
```
