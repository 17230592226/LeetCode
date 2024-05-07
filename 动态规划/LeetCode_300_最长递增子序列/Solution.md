![image](https://github.com/17230592226/LeetCode/assets/57279736/88e7108b-9585-4c84-b5ac-d0ff3cab5830)# 题目
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

![image](https://github.com/17230592226/LeetCode/assets/57279736/2575de38-328b-4e98-83a2-9d280c76124f)
# 代码
# go
```
//定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。


func lengthOfLIS(nums []int) int {
    dp:=make([]int,len(nums))
    for i:=0;i<len(nums);i++{
        dp[i]= 1
        for j:=0;j<i;j++{
            if nums[i]>nums[j]{
                dp[i] = max(dp[i],dp[j]+1)
            }
        }
    }
    return slices.Max(dp)
}
```
# 复杂度
- 时间复杂度：O(n^2)
- 空间复杂度：O(n)
