/*
Search in an almost sorted array
Medium??

Given a sorted integer array arr[] consisting of distinct elements, where some elements of the array are moved to either of the adjacent positions, i.e. arr[i] may be present at arr[i-1] or arr[i+1].
Given an integer target.  You have to return the index ( 0-based ) of the target in the array. If target is not present return -1.
00:02 understood the question
00:04 trying an approach where we just apply the binary search
00:08 accepted
00:09 tle on the gfg site
 */

package GFG;

public class searchInAnAlmostSortedArray {
    static void main() {
        int[] nums = {10, 3, 40, 20, 50, 80, 70};
        int target = 3;
        System.out.println(findTargetGFG(nums, target));
    }

    static int findTargetGFG(int[] nums, int target)
    {
        int start = 0, end = nums.length - 1;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (nums[mid] == target)
                return mid;
            else if (mid > start && nums[mid-1] == target)
                return mid -1;
            else if (mid < end && nums[mid + 1] == target)
                return mid + 1;

            if (nums[mid] > target)
                end = mid - 2;
            else
                start = mid + 2;
        }

        return -1;
    }

    static int findTarget(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;

        while (start < end)
        {
            int mid = start + (end - start)/2;
            if (target == nums[mid])
            {
                return mid;
            }
            else if (target > nums[mid] && mid > 0)
            {
                if (nums[mid - 1] == target)
                    return mid - 1;
                start = mid + 1;
            }
            else if (target < nums[mid] && mid < nums.length-1)
            {
                if (nums[mid + 1] == target)
                    return mid + 1;
                end = mid - 1;
            }
        }
        return -1;
    }
}
