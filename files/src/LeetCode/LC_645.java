/*
645. Set Mismatch
Easy

00:01 cyclic sort question, but return index and the misplaced element
00:05 misinterpreted the output demands, need to return the element that is duplicated and the element missed
00:05 accepted
 */

package LeetCode;

import java.util.Arrays;

public class LC_645 {
    static void main() {
        int[] nums = {1,1};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length)
        {
            if (nums[i] != nums[nums[i] - 1])
            {
                int correct = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else
            {
                i++;
            }
        }

        int[] result = {0,0};
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1)
            {
                result[0] = nums[j];
                result[1] = j+1;
            }
        }
        return result;
    }

}
