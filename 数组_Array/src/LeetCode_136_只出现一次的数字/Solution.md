# 题目
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间

示例 1 ：

输入：nums = [2,2,1]
输出：1
示例 2 ：

输入：nums = [4,1,2,1,2]
输出：4
示例 3 ：

输入：nums = [1]
输出：1
 

提示：

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
除了某个元素只出现一次以外，其余每个元素均出现两次。
# 代码
![image](https://github.com/17230592226/LeetCode/assets/57279736/1f1e281a-8fdd-49be-abb2-b649fa9300e0)

## 位运算
```
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int s = 0;
        for (int num:nums){
            s^=num;
        }
        return s;
    }
};
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/d3796c34-b80f-433b-9439-d53853abf021)

# go
```
func singleNumber(nums []int) int {
    s :=0
    for _,v :=range nums{
        s ^= v
    }
    return s
}
```
