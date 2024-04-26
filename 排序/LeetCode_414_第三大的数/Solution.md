# 题目
给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

示例 1：

输入：[3, 2, 1]
输出：1
解释：第三大的数是 1 。
示例 2：

输入：[1, 2]
输出：2
解释：第三大的数不存在, 所以返回最大的数 2 。
示例 3：

输入：[2, 2, 3, 1]
输出：1
解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 

提示：

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？

# 解法：有序集合

可以遍历数组，同时用一个有序集合来维护数组中前三大的数。具体做法是每遍历一个数，就将其插入有序集合，若有序集合的大小超过 3，就删除集合中的最小元素。</br>
这样可以保证有序集合的大小至多为 3，且遍历结束后，若有序集合的大小为 3，其最小值就是数组中第三大的数；若有序集合的大小不足 3，那么就返回有序集合中的最大值。

```
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        //unordered_set没有s.begin()方法
        //set中元素都是由小到大排好序的
        set<int> s;
        for(int num : nums){
            s.insert(num);
            if(s.size() > 3){
                s.erase(s.begin());
            }
        }
        return s.size() == 3 ? *s.begin() : *s.end();

    }
};
```
# 复杂度
- 时间复杂度：，O(n)，其中 n 是数组 nums 的长度。由于有序集合的大小至多为 3，插入和删除的时间复杂度可以视作是 O(1) 的，因此时间复杂度为 O(n)。
- 空间复杂度：O(1))。

# go语言
```
func thirdMax(nums []int) int {
    sort.Sort(sort.Reverse(sort.IntSlice(nums)))
    for i,diff:=1,1;i<len(nums);i++{
        if nums[i]!=nums[i-1]{
            diff++
            if diff==3{
                return nums[i]
            }
        }
    }
    return nums[0]
}
```
