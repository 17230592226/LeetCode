# 题目
给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。

注意 这个数列必须是 严格 递增的。
![image](https://github.com/17230592226/LeetCode/assets/57279736/5048087f-3480-4342-9365-e5911e43699e)

# 代码
## go
```
func findNumberOfLIS(nums []int) int {
    //最长上升子序列的长度为
    maxLen:=0
    ans:=0
    //dp表示以 nums[i] 结尾的最长上升子序列的长度
    //dp表示以 nums[i] 结尾的最长上升子序列的个数
    dp:=make([]int,len(nums))
    cnt:=make([]int,len(nums))
    for i:=0;i<len(nums);i++{
        dp[i]= 1
        cnt[i]=1
        for j:=0;j<i;j++{
            if nums[i]>nums[j]{
                if dp[j]+1>dp[i]{
                    dp[i] = dp[j]+1
                    //由于nums[i]>nums[j]，所以新的最大序列长度的个数是在j时的个数
                    cnt[i] = cnt[j]
                }else if dp[j]+1 == dp[i]{
                    //相当于以dp[i]结尾的 i和j的相同的序列长度的总和
                    cnt[i] = cnt[i]+cnt[j]
                }
                
            }
        }
        if dp[i] > maxLen{
            maxLen = dp[i]
            ans = cnt[i]
        }else if dp[i] == maxLen{
            //不是以dp[i]结尾的 的某一个j与dp[i]的最大长度相同
            ans = ans+cnt[i]
        }
    }
    return ans
}
```
# 复杂度
- 时间复杂度：O(n^2)
- 空间复杂度：O(n)


