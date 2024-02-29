package LeetCode_1_两数之和;

import java.util.HashMap;

/**
 * @Auther: zhaohaishen
 * @Date: 2024-02-29 - 02 - 29 - 10:05
 * @Description: LeetCode_1_两数之和
 * @version: 1.0
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int len =nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(len-1);
        for (int i = 0; i < len; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;

    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int s[]=twoSum(nums,target);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

    }
}
