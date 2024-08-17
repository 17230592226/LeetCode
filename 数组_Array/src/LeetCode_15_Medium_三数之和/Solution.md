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

//注意：可以发现，如果我们固定了前两重循环枚举到的元素 a 和 b，那么只有唯一的 c 满足 a+b+c=0。当第二重循环往后枚举一个元素 b′时，由于 b′>b，那么满足 a+b′+c′=0 的 c′一定有 c ′<c，即 c ′在数组中一定出现在 c 的左侧。也就是说，我们可以从小到大枚举 b，同时从大到小枚举 c，即第二重循环和第三重循环实际上是并列的关系。
//我们就可以保持第二重循环不变，而将第三重循环变成一个从数组最右端开始向左移动的指针

作者：力扣官方题解
链接：https://leetcode.cn/problems/3sum/solutions/284681/san-shu-zhi-he-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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
```
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
```
