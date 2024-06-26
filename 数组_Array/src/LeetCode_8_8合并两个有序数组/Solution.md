# 88. 合并两个有序数组

给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
示例 3：

输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 

提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？

# 代码
```
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = m-1;
        int j = n-1;
        int dst = m + n - 1;
        //从后往前面插入，这个其实就是另类的合并插入
        while(i >= 0 && j >= 0){
        //将较大的数插入的后面，也就是dst的位置
            if(nums1[i] > nums2[j]){
                nums1[dst] = nums1[i];
                i--;
                dst--;
            }
            else{
                nums1[dst] = nums2[j];
                j--;
                dst--;
            }
        }
        //只有当nums2的数组有数时，说明nums2数小，需要插入。而nums1
        //则不需要，因为nums1所留的小的数，仍然在原来的位置上。
        while(j >= 0){
            nums1[dst] = nums2[j];
            j--;
            dst--;
        }

    }
};
```
# 步骤
1. 定义3个变量，分别指向：i->第一个数组有效的最后索引，j->第二个数组的最后索引，dst->第一个数组的最后；
2. 比较i和j的值的大小，我们的目的是，将两个数组有效的数放在dst位置，随后将nums1[dst]的位置进行赋值，i或j--,dst--；
3. 最后看nums1和nums2的数组有效值索引，即i和j，如果i>=0，则不必要管，自动就是非递减排序。若j>=0，则将剩余的数据（较小的数）进行赋值。

# 复杂度
时间复杂度：只移动了m+n次，因此复杂度为O(m+n)。
空间复杂度：没有开辟新的空间。

# go
```
func merge(nums1 []int, m int, nums2 []int, n int)  {
    i,j:=m-1,n-1
    z:=m+n-1
    for i>=0 && j>=0{
        if nums2[j] > nums1[i]{
            nums1[z] = nums2[j]
            j--
            z--
        }else{
            nums1[z] = nums1[i]
            i--
            z--
        }
    } 
    for j>=0{    
        nums1[z]=nums2[j]
         j--
         z--
        
    }

}
```
