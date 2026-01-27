/*
34. Find First and Last Position of Element in Sorted Array
Medium

00:01 read the problem
00:02 the problem uses two binary searches, first to find the first position, and second to find the last position
00:05 first index was returning the wrong answer was not working
00:06 did not take care of the default answer
00:07 wrong output on [1] testcase
00:12 the problem was that i was using while (start < end) as the condition for the while loop, but the condition should be (start <= end), because start and end can come to the same index.
 */

package LeetCode;

import java.util.Arrays;

public class LC_34 {
    static void main() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int first = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                first = mid;
                end = mid-1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = nums.length - 1;
        int last = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}
