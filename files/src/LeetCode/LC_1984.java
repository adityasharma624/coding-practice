/*
1984. Minimum Difference Between Highest and Lowest of K Scores
Easy

Example 1:

Input: nums = [90], k = 1
Output: 0

Input: nums = [9,4,1,7], k = 2
Output: 2

 */

package LeetCode;

import java.util.Arrays;

public class LC_1984 {
    static void main() {
        int[] nums = {9,4,1,7};
        int target = 2;
        System.out.println(minimumDifference(nums, target));
    }

    static int minimumDifference(int[] nums, int k) {
        // sorted the array in ascending order, which means that i will be the smallest element while k+i-1 will be the largest element in the window.
        Arrays.sort(nums);
        int result = nums[k-1] - nums[0];
        for (int i = 0; i < nums.length-k+1; i++)
        {
            if (nums[i+k-1] - nums[i] < result)
            {
                result = nums[i+k-1] - nums[i];
            }
        }
        return result;
    }

}
