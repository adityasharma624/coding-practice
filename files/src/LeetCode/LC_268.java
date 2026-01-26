/*
268. Missing Number
Easy

00:01 a simple maths problem, get the sum of n numbers and deduct the sum of the array and find the element
00:03 accepted
*/

package LeetCode;

public class LC_268 {
    static void main() {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }

    static int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums)
        {
            sum += num;
        }
        int n = nums.length;
        int totalSum = (n*(n+1))/2;
        return totalSum-sum;
    }
}
