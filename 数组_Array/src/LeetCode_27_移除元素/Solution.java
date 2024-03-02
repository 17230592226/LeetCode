package LeetCode_27_移除元素;

import javax.sound.midi.Soundbank;

/**
 * @Auther: zhaohaishen
 * @Date: 2024-03-02 - 03 - 02 - 21:35
 * @Description: LeetCode_27_移除元素
 * @version: 1.0
 */
public class Solution {
    static int[] nums = {0,1,2,2,3,0,4,2};
    public static int removeElement(int[] nums, int val) {
        int src=0;
        int dst=0;

        while(src <= nums.length-1){
            if(nums[src] != val){
                nums[dst] = nums[src];
                src++;
                dst++;
            }else{
                src++;
            }
        }
        return dst;
    }
    public static void main(String[] args) {
        int l = removeElement(nums,2);
        for (int i :
                nums) {
            System.out.println(i);
        }
        System.out.println(l);
    }
}
