package LeetCode_26_删除数组中的重复项;

/**
 * @Auther: zhaohaishen
 * @Date: 2024-03-01 - 03 - 01 - 20:42
 * @Description: LeetCode_26_删除数组中的重复项
 * @version: 1.0
 */
public class Solution {
    static int[] nums = {1,1,2};
    public static int removeDuplicates(int[] nums) {
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


    public static void main(String[] args) {
        removeDuplicates(nums);
        for (int i:
             nums) {
            System.out.println(i);
        }

    }
}