# 题目

给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 

示例 1：

输入：nums = [1,2,3,1]
输出：true
示例 2：

输入：nums = [1,2,3,4]
输出：false
示例 3：

输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
 

提示：

1 <= nums.length <= 105
-109 <= nums[i] <= 109

# 解法1：哈希
```
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int , int> counts ;
        for(int num : nums){
            counts[num]++;
            if(counts[num] == 2){
                return true;
            }
        }
        return false;
    }
};
```
# 复杂度
- 时间复杂度：O(n)
- 空间复杂度：O(n)

# 解法2：排序
```
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        for(int i = 0; i < nums.size() - 1 ; i++ ){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
};
```
# 复杂度
- 时间复杂度：O(nlongn)
- 空间复杂度：O(logn)

# go
```
func containsDuplicate(nums []int) bool {
    map1:=map[int]int{}
    for _,v :=range nums{
        map1[v]++
        if map1[v]==2{
            return true
        }
    }
    return false
}
```
