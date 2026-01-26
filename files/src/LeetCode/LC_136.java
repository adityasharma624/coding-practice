/*
136. Single Number
Easy

00:01 read the problem O(n) time and O(1) space
00:01 which means this can't be solved using hashmap
00:01 maybe XOR operator?
00:02 accepted
 */

package LeetCode;

public class LC_136 {
    static void main() {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums)
        {
            result = result ^ num;
        }
        return result;
    }
}

