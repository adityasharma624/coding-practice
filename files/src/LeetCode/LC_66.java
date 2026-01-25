/*
66. Plus One
Easy

00:01 understood the problem
00:01 basically add 1 to the last digit, if 9 then carry over that
00:01 some sort of carry variable
00:10 used i instead of j, which messed up the results

 */

package LeetCode;

import java.util.Arrays;

public class LC_66 {
    static void main() {
        int[] digits = {4,3,2,1};
//        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    static int[] plusOne(int[] digits) {
        boolean carry = true;
        int i = digits.length-1;
        while (i >= 0 && carry) {
            int digit = digits[i] + 1;
            if (digit > 9)
            {
                digits[i] = 0;
                carry = true;
            }
            else
            {
                digits[i] = digit;
                carry = false;
            }
            i--;
        }

        if (i == -1 && carry)
        {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int j = 1; j < digits.length+1; j++) {
                result[j] = digits[j-1];
            }
            return result;
        }
        return digits;
    }

}
