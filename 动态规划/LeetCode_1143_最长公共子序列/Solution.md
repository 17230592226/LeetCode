![image](https://github.com/17230592226/LeetCode/assets/57279736/0530787f-c2da-4607-a9b8-60a63b975ead)![image](https://github.com/17230592226/LeetCode/assets/57279736/266bea05-fa9a-4b1f-9a33-853941514ca3)# 题目

给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
![image](https://github.com/17230592226/LeetCode/assets/57279736/51643dfb-4244-49d5-9550-4ef6730ced9d)
# 代码
## go
```
func longestCommonSubsequence(text1 string, text2 string) int {
    m,n:=len(text1),len(text2)
    dp:=make([][]int,m+1)
    for i:=range dp{
        dp[i] = make([]int ,n+1)
    }
    for i:=1;i<=m;i++{
        for j:=1;j<=n;j++{
            if text1[i-1] ==text2[j-1]{
                dp[i][j] = dp[i-1][j-1]+1
            }else{
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
            }
        }
    }
    return dp[m][n]
}
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/2c9bcdf5-db0a-4d1a-a4f9-55ea6f2ce897)
## 复杂度
- 时间复杂度：O(mn)，其中 m 和 n 分别是字符串 text1和text 2的长度。二维数组 dp 有 m+1 行和n+1 列，需要对 dp 中的每个元素进行计算。
- 空间复杂度：O(mn)，创建了二维数组dp



