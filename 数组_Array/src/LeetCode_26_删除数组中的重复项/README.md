# 题目
26. 删除有序数组中的重复项
给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
返回 k 。
判题标准:

系统会用下面的代码来测试你的题解:

int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
如果所有断言都通过，那么您的题解将被 通过。

 

示例 1：

输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 

提示：

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 已按 非严格递增 排列

# 代码
````
public int removeDuplicates(int[] nums) {
        //1、边界判定
       if(nums.length<=1)return 1;
       //2、设定两个指针，用于指向唯一元素和当前已经遍历到的数。
       int low = 0, fast=1;
       while(fast <= nums.length-1){
           if(nums[low] != nums[fast]){
               //3.判断两个数是否相等
               //若两个不同的数相邻，则让low向前走一个，并进行交换
               //若两个不同的数不相邻，仍让low向前走一个，并进行交换
               low++;
               nums[low] = nums[fast];
           }
           fast++;
       }
       //将长度进行输出
       return low+1;
    }
````

# 步骤
1. 边界判定
2. 设定两个指针，用于指向唯一元素和当前已经遍历到的数。
3. 判断两个数是否相等
  若两个不同的数相邻，则让low向前走一个，并进行交换
  若两个不同的数不相邻，仍让low向前走一个，并进行交换


# 复杂度分析
时间复杂度：O(n)，其中 n 是数组的长度。快指针和慢指针最多各移动 n 次。</br>
空间复杂度：O(1)。只需要使用常数的额外空间。

## go
```
func removeDuplicates(nums []int) int {
    if len(nums)==1{
        return 1;
    }
    low , fast :=0,1
    for fast<len(nums){
        if nums[low]!=nums[fast]{
            low++
            nums[low]=nums[fast]
        }
        fast++
    }
    return low+1
}
```
