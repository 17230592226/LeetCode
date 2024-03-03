package LeetCode_66_加一;

import java.math.BigInteger;

/**
 * @Auther: zhaohaishen
 * @Date: 2024-03-03 - 03 - 03 - 11:00
 * @Description: LeetCode_66_加一
 * @version: 1.0
 */
public class Solution {
    static int[] digits = {4,3,2,1};

    public static int[] plusOne(int[] digits) {
        String s = "";
        for (int i = 0; i < digits.length; i++) {
            s = s + digits[i];
        }

        BigInteger big = new BigInteger(s);
        big = big.add(BigInteger.ONE);
        String bigs = big.toString();
        if (bigs.length() > digits.length) {
            int[] newDigits = new int[s.length()];
            int intsa[] = putNewNum(newDigits, bigs);
            return intsa;
        } else {
            int intsa[] = putNewNum(digits, bigs);
            return intsa;
        }

    }

    public static int[] putNewNum(int[] a, String s) {
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return a;
    }


    public static void main(String[] args) {
        plusOne(digits);
        for (int i :
                digits) {
            System.out.println(i);
        }
    }
}
