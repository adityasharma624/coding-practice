/*
1752. Check if Array Is Sorted and Rotated
Easy

00:01 read the problem
00:01 we can have a check variable, which checks for cliffs and if it goes greater than 1, then it is unsorted
00:03 added condition for checking last item < first item
00:04 accepted
 */

package LeetCode;

public class LC_1752 {
    static void main() {
        int[] nums = {3,4,5,1,2};
        System.out.println(check(nums));
    }
    static boolean check(int[] nums) {
        int check = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1])
                check++;
        }

        if (nums[nums.length-1] > nums[0])
            check++;

        if (check > 1)
            return false;
        return true;
    }
}
