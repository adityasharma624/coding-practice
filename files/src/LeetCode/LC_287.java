/*
287. Find the Duplicate Number
Medium

00:01 looking at the question, we can go with cyclic sort.
00:03 i need to practice cyclic sort a bit more.
00:04 accepted.
 */

package LeetCode;

public class LC_287 {
    static void main() {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length)
        {
            if (nums[i] != nums[nums[i]-1])
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
                return nums[j];
        }
        return -1;
    }
}
