# 题目描述
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]
 

提示：

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案

# 代码
```
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(len-1);
        for(int i = 0; i < len ;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
```
# 解析
1、存放键值对（nums[i],i），记录值和当前的索引。</br>
2、当新添入nums[i+1]时，查看此时的map的键中是否存在（target-nums[i]）的键。</br>
3、如果存在，输出当前数索引和（target-nums[i]）的值（索引）。
# 结果
![image](https://github.com/17230592226/LeetCode/assets/57279736/e80652b7-0f2b-4eca-b91d-8908e59710ed)
![image](https://github.com/17230592226/LeetCode/assets/57279736/6fccc280-3ed2-4d1a-a5bf-7813f035d4a6)

# go
```
func twoSum(nums []int, target int) []int {
    hashTable:=map[int]int{}
    for i,x:=range nums{
        if p,ok:=hashTable[target-x];ok{
            return []int{p,i}
        }
        hashTable[x] = i
    }
    return nil
}
```

