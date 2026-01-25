/*
153. Find Minimum in Rotated Sorted Array
Medium

00:00 begin
00:01 finished reading the question.
00:01 all elements are unique, approach of 33 is applicable, O(log n)
00:07 since the array is sorted and rotated, the minimum element will be the one next to the pivot.
00:10 error with {2,3,4,5,1} test case, pivot is returning to be -1
00:13 mixed up the start, end update statements
00:14 accepted
 */

package LeetCode;

public class LC_153 {
    static void main() {
        int[] nums = {2,3,4,5,1};
        System.out.println(findMin(nums));
    }

    static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if (pivot == -1) return nums[0];
        return nums[pivot+1];
    }

    static int findPivot(int[] nums)
    {
        int start = 0;
        int end = nums.length-1;

        while (start < end)
        {
            int mid = start + (end - start)/2;
            if (mid > 0 && nums[mid-1] > nums[mid])
            {
                return mid-1;
            }
            else if (mid < nums.length-1 && nums[mid+1] < nums[mid])
            {
                return mid;
            }

            if (nums[mid] < nums[start])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return -1;
    }
}

