/*
442. Find All Duplicates in an Array
Medium

00:01 read the question, cyclic sort, and return misplaced elements
00:03 accepted
 */

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC_442 {
    static void main() {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));

    }
    public static List<Integer> findDuplicates(int[] nums) {
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

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1)
                result.add(nums[j]);
        }
        return result;
    }
}
