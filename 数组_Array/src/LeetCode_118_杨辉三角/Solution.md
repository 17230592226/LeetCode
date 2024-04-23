# 题目 杨辉三角
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:

输入: numRows = 1
输出: [[1]]

 # 代码
```
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ret(numRows);
        for(int i = 0;i< numRows;i++){
            ret[i].resize(i + 1);
            ret[i][0] =1;
            ret[i][i]=1;
            if (i>=2){
                for(int j = 1;j< i;j++){
                ret[i][j]=ret[i-1][j-1]+ret[i-1][j];
            }
            }
        }
        return ret;
    }
};
```
# 复杂度：
- 时间复杂度：时间复杂度：O(numRows^2)
- 空间复杂度：O(1)。不考虑返回值的空间占用

# go语言编写代码
```
func generate(numRows int) [][]int {
    ans:=make([][]int ,numRows)
    for i:=range ans{
        ans[i] = make([]int,i+1)
        ans[i][0] =1
        ans[i][i]=1
        for j:=1;j<i;j++{
            ans[i][j] = ans[i-1][j] +ans[i-1][j-1]
        }
    }
    return ans
}
```
