# 题目
给定两个数组 nums1 和 nums2 ，返回 它们的交集
 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
 

提示：

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

## 解法1：哈希
```
//遇到的问题，没有定义第二个集合set2，直接判断后加入了数组，这样并没有判断第二个数组重复的元素给去掉。
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> v;
        unordered_set<int> set1;
        unordered_set<int> set2;
        for(int num1 : nums1){
            set1.insert(num1);
        }
        for(int num2 : nums2){
            if(set1.count(num2)){
                set2.insert(num2);
            }
        }
        for(int s : set2){
            v.push_back(s);
        }
        return v;
    }
};
```
# 复杂度
- 时间复杂度：O(n)
- 空间复杂度：O(n)

# go 语言
```
func intersection(nums1 []int, nums2 []int) []int {
    var  res []int
    set1:= map[int]struct{}{}
    set2:=map[int]struct{}{}
    for _,v :=range nums1{
        set1[v] = struct{}{}
    }
    for _,v:=range nums2{
        set2[v] = struct{}{}
    }
    if len(set1) >len(set2){
        set1,set2=set2,set1
    }
 //set的遍历 第一个返回值map 的键，第二个返回值是 map 的值
    for _,v:=range set1{
      //判断它的键有没有这个 v 这个值
        if _,has:=set2[v];has{
            res = append(res,v)
        }
    }
    return res
}
```
