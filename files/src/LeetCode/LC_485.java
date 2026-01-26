/*
485. Max Consecutive Ones
Easy

00:01 read the problem
00:01 can keep a variable result, and a current variable, when we encounter a 0, we update the value of result based on current
00:02 accepted
*/

package LeetCode;

public class LC_485 {
    static void main() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int current = 0;
        for (int num : nums)
        {
            if (num == 1)
            {
                current++;
                if (current > result)
                    result = current;
            }
            else
            {
                current = 0;
            }
        }
        return result;
    }
}
