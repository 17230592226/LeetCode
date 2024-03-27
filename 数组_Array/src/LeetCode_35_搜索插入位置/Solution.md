# 题解
35. 搜索插入位置

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

 

示例 1:

输入: nums = [1,3,5,6], target = 5
输出: 2
示例 2:

输入: nums = [1,3,5,6], target = 2
输出: 1
示例 3:

输入: nums = [1,3,5,6], target = 7
输出: 4
 

提示:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 为 无重复元素 的 升序 排列数组
-104 <= target <= 104

# 代码
```
//这道题其实就是二分查找
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int i = 0;
        int j = nums.size()-1;
        int mid = 0;
        //刚刚这里出错了，写成了 i > j
        //当i == j , 实际上是判断i=j的这个下标与 target的比较，这是必要的。
        while(i <=  j){
            mid = (i + j) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target ){
                j = mid - 1;    
            }else{
                i = mid + 1;              
            }
            
        }
        return i;
    }
};
```
# 步骤
1. 定义三个指针。
2. 注意循环条件是i<=j，也就是如果他们到达同一个位置时仍让他们向前或向后走一步。
3. 注意 j=mid-1以及i=mid+1 ,让他们前进或后退，若只有i=mid和j=mid,则i永远会小于等于j。
# 复杂度
时间复杂度： O(log n)
空间复杂度： O(1)


