# 题解
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
 

提示：

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

进阶：

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

# 解法1：哈希
```
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> map1;
        unordered_map<int,int> map2;
        vector<int> v;

        for(int num1 : nums1){
            map1[num1]++;
        }
        for(int num2 : nums2){
            map2[num2]++;
        }
       //遍历  这个也可以  for(pair<const int,int>& kv:map){
        for(auto& kv : map1){
            if(map2.count(kv.first)){
                for(int i = 0 ;i < min(map2[kv.first],map1[kv.first]);i++)
                v.push_back(kv.first);
            }
        }
        return v;
        

    }
};
```

# 复杂度：
- 时间复杂度：O(n)
- 空间复杂度：O(n)

# go 语言
```
func intersect(nums1 []int, nums2 []int) []int {
   m:=map[int]int{}
   for _,v :=range nums1{
    m[v]++
   }

    res :=[]int{}
    for _,v:=range nums2{
        if m[v]>0{
            res = append(res,v)
            m[v]--
        }
    }
    return res

}
```
