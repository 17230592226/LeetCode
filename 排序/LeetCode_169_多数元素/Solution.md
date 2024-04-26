# 题目
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2
 

提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

# 代码
```
//冒泡排序，超出时间限制  想法：排序后，⌊n/2⌋的位置一定是众数
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size() - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[nums.size() / 2];
    }
};
```
## 解法1：哈希表
```
//我们使用哈希映射（HashMap）来存储每个元素以及出现的次数。对于哈希映射中的每个键值对，键表示一个元素，值表示该元素出现的次数。

//我们用一个循环遍历数组 nums 并将数组中的每个元素加入哈希映射中。在这之后，我们遍历哈希映射中的所有键值对，返回值最大的键。我们同样也可以在遍历数组 nums 时候使用打擂台的方法，维护最大的值，这样省去了最后对哈希映射的遍历。


class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> counts;
        int majority = 0, cnt = 0;
        for (int num: nums) {
            ++counts[num];
            if (counts[num] > cnt) {
                majority = num;
                cnt = counts[num];
            }
        }
        return majority;
    }
};

```
## 复杂度
- 时间复杂度：O(n)，其中 n 是数组 nums 的长度。我们遍历数组 nums 一次，对于 nums 中的每一个元素，将其插入哈希表都只需要常数时间。
- 空间复杂度：O(n)。哈希表最多包含 n−⌊n/2⌋ 个键值对，所以占用的空间为 O(n)。

## 解法2：排序（这里与我写的代码想法类似，只不过不是冒泡）
​
```
class Solution {
public:
    int majorityElement(vector<int>& nums) {
       sort(nums.begin(),nums.end());
       return nums[nums.size() / 2];

    }

};
```
## 复杂度
- 时间复杂度：O(nlog⁡n)。将数组排序的时间复杂度为 O(nlog⁡n)。
- 空间复杂度：空间复杂度：O(log⁡n)。如果使用语言自带的排序算法，需要使用 O(log⁡n) 的栈空间。如果自己编写堆排序，则只需要使用 O(1)的额外空间。



## 解法3：随机数
```
//由于一个给定的下标对应的数字很有可能是众数，我们随机挑选一个下标，检查它是否是众数，如果是就返回，否则继续随机挑选
class Solution {
public:
    int majorityElement(vector<int>& nums) {
       while(true){
        int candidate = nums[rand() % nums.size()];
        int count = 0;
        for(int num : nums){
            if(num == candidate){
                count++;
            }
        }
        if(count > nums.size() / 2){
            return candidate;
        }
       }
    return -1;
    }

};
```
## 复杂度
![image](https://github.com/17230592226/LeetCode/assets/57279736/bd72f5b2-b05d-4207-a3ff-d3cb861ae510)

## 解法4：Boyer-Moore 投票算法： 如果我们把众数记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
```
class Solution {
public:
    int majorityElement(vector<int>& nums) {
       int candidate = -1;
       int count = 0;

       for(int num : nums){
        if(num == candidate) count++;
        else if (--count < 0){
            candidate = num;
            count = 1;
        }
       }
       return candidate;
    }

};
```
## 复杂度
- 时间复杂度：O(n)。Boyer-Moore 算法只对数组进行了一次遍历。
- 空间复杂度：空间复杂度：O(1⁡n)。Boyer-Moore 算法只需要常数级别的额外空间。

# go
## 哈希
```
func majorityElement(nums []int) int {
    map1:= map[int]int{}
    majority :=nums[0]
    cnt :=0
    for _,v :=range(nums){
        map1[v]++
        if(map1[v]>cnt){
            cnt = map1[v]
            majority = v
        }
    }
    return majority
}
```

```
func majorityElement(nums []int) int {
    candidate ,count:=-1,0
    for _,num :=range nums{
        if num ==candidate{
            count++
        }else{
            count--
            if count<0{
            candidate = num
            count=1
        }
        } 
    }
    return candidate
}
```
