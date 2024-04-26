# 题目
给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

 

示例 1：

输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
示例 2：

输入：nums = [0,1]
输出：2
解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
示例 3：

输入：nums = [9,6,4,2,3,5,7,0,1]
输出：8
解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
示例 4：

输入：nums = [0]
输出：1
解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 

提示：

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
nums 中的所有数字都 独一无二
 

进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

# 解法1： 排序
```
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin() , nums.end());
        int i = 0;
        for(int num : nums){
            if(num != i){
                return i;
            }
            i++;
        }
        return i;
    }
};
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/5e7af5cb-e75b-4c90-a76b-da0ed9e376df)
# 解法2：哈希
```
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        unordered_set<int> set;
        int n = nums.size();
        for(int i =0 ;i < n ;i++){
            set.insert(nums[i]);
        }
        int missing = -1;
        for(int i = 0; i <= n;i++){
            if(!set.count(i)){
                missing = i;
                break;
            }
        }
        return missing;
    }
};
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/b1a02a69-f5a7-49dd-a591-6cc994148c9d)
# 解法3：位运算
![image](https://github.com/17230592226/LeetCode/assets/57279736/4b90d4ff-af51-4357-8b3d-b61d26dc7e4e)

```
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int res = 0;
        int n = nums.size();
        for(int i = 0; i < n;i++){
            res ^= nums[i];
        }
        for(int i = 0;i <=n; i++){
            res ^= i;
        }
        return res;
    }
};
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/433a7386-ea73-44b7-8a7c-b82ca9715bcb)

# 解法4：数学

![image](https://github.com/17230592226/LeetCode/assets/57279736/b676835f-0258-43eb-a4c4-e2fb74834623)

```
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int total = n * (n+1) / 2;
        int sum = 0;
        for(int i = 0; i < n;i++){
            sum = sum + nums[i];
        }
        return total - sum;
    }
};
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/2dde327f-bb20-4a00-920b-f6dd2890e8cc)

# go 语言
```
func missingNumber(nums []int) int {
has := map[int]bool{}
    for _, v := range nums {
        has[v] = true
    }
    for i := 0; ; i++ {
        if _,ok:= has[i]; !ok{
            return i
        }
    }
}
```


