package LeetCode_66_加一;

/**
 * @Auther: zhaohaishen
 * @Date: 2024-03-03 - 03 - 03 - 11:34
 * @Description: LeetCode_66_加一
 * @version: 1.0
 */
public class Solution2 {
    static int[] digits = {9,9};
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int a[] = new int[digits.length + 1];
        a[0] = 1;
        return a;
    }
    public static void main(String[] args) {
        int[]res = plusOne(digits);
        for (int i :
                res) {
            System.out.println(i);
        }
    }
}
