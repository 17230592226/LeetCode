# 题目 杨辉三角 II
给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。
示例 1:

输入: rowIndex = 3
输出: [1,3,3,1]
示例 2:

输入: rowIndex = 0
输出: [1]
示例 3:

输入: rowIndex = 1
输出: [1,1]

# 代码：
## 递推 
```
class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<vector<int>> ret(rowIndex+1);
        for (int i = 0; i <= rowIndex; i++) {
            ret[i].resize(i + 1);
            ret[i][0] = 1;
            ret[i][i] = 1;
            if (i >= 2) {
                for (int j = 1; j < i; j++) {
                    ret[i][j] = ret[i - 1][j - 1] + ret[i - 1][j];
                }
            }
        }
        return ret[rowIndex];
    }
};
```
# 复杂度：
- 时间复杂度：时间复杂度：O(rowIndex^2)
- 空间复杂度：O(1)。不考虑返回值的空间占用

# go代码
## 递推
```
func getRow(rowIndex int) []int {
    res:=make([][]int,rowIndex+1)
    for i:=0;i<=rowIndex;i++{
        res[i] = make([]int,i+1)
        res[i][0]=1
        res[i][i]=1
        for j:=1;j<i;j++{
            res[i][j] = res[i-1][j-1]+res[i-1][j]
        }
    }
    return res[rowIndex]
}
```
```
