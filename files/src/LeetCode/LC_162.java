/*
162. Find Peak Element
Medium

00:00 implement the "find pivot" function.
00:02 test case failed
00:03 adding in a condition to first check whether the first and last element are larger than their next/previous element
00:06 not that simple ig
00:08 issue with my findpivot
00:09 this function works for a rotated sorted array, need to improvise.

 */

package LeetCode;

public class LC_162 {
    static void main() {
//        int[] nums = {1,2,1,3,5,6,4};
        int[] nums = {1,6,5,4,3,2,1};
        System.out.println(findPeakElement(nums));
    }

    static int findPeakElement(int[] nums)
    {
        // edge cases
        if (nums.length == 1 || nums[0] > nums[1])
            return 0;
        else if (nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;

        int start = 0;
        int end = nums.length-1;

        while (start < end)
        {
            int mid = start + (end - start)/2;
            
        }
        return -1;
    }
}
