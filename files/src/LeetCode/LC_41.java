/*
41. First Missing Positive
Hard

00:01 read the problem
00:01 cyclic sort problem, but have to ignore x<=0
00:03 need to add upper bound of acceptable elements as well
00:04 if every element is already in the array, we should return the last element + 1, since the array is sorted
 */

package LeetCode;

public class LC_41 {
    static void main() {
        int[] nums = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length)
        {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1])
            {
                int correct = nums[i] - 1;
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }
            else
            {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1)
                return j+1;
        }
        return nums[nums.length-1] + 1;
    }
}
