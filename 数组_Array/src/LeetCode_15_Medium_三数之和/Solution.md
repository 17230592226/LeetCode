# 题目
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
![image](https://github.com/17230592226/LeetCode/assets/57279736/1a2d6272-ea34-4a44-a301-e060e0ad3ca6)

# 代码
```

//伪代码：
nums.sort()
for first = 0 .. n-1
    // 只有和上一次枚举的元素不相同，我们才会进行枚举
    if first == 0 or nums[first] != nums[first-1] then
        for second = first+1 .. n-1
            if second == first+1 or nums[second] != nums[second-1] then
                for third = second+1 .. n-1
                    if third == second+1 or nums[third] != nums[third-1] then
                        // 判断是否有 a+b+c==0
                        check(first, second, third)

//注意：first == 0 确保例如（-1,-1,-1,2）中只有在开头中，前两个（-1,-1）的不重复，中间的（-1，-1）遇到nums[first] != nums[first-1]则跳过，即之后的与first相同的直接跳过。
//second == first+1 确保 first和second可以连续一次，之后的与second的直接跳过

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        vector<vector<int>> ans;
        for(int first = 0;first<n;first++){
            if (first>0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = n-1;
            int target = -nums[first];
            for(int second=first+1;second<n;second++){
                if(second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
            //第三个元素一定是在第二个元素之后的，并且第二个和第三个元素之后要大于目标值
                while(second<third && nums[second] + nums[third]>target){
                    third--;
                }
    //(这意味着之后的second与任何一个second都是要大于target的，因此直接弹出)
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third]==target){
                    ans.push_back({nums[first],nums[second],nums[third]});
                }
            }
        }
        return ans;
    }
};
```
# 思路
1. 从小到大排序。
2. first、second、third只需要在特定下允许first、second、third重复一次，其他的不允许重复。
3. 根据第一个元素可以，知道第二个和第三个元素之和，以此减少一层循环。
 ![image](https://github.com/17230592226/LeetCode/assets/57279736/dc008a8c-ecec-4328-8454-e8b084f7d6bf)


# go
func threeSum(nums []int) [][]int {
    n :=len(nums)
    sort.Ints(nums)
    ans:=make([][]int ,0)

    for first:=0;first<n;first++{
        if first>0 && nums[first] == nums[first-1]{
            continue
        }
        thrid := n-1
        target:=-nums[first]
        for second := first+1;second<n;second++{
            if second>first+1 && nums[second]==nums[second-1]{
                continue
            }
            for second < thrid && nums[second] +nums[thrid] > target{
                thrid--;
            }
            if second==thrid{
                break
            }
            if nums[second] +nums[thrid] == target{
                ans = append(ans,[]int{nums[first],nums[second],nums[thrid]})
            }
        }
    }
    return ans
}
