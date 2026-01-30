/*
in every step, we are comparing adjacent elements
with the first pass through the array the largest element goes in the end.
sinking sort, or, exchange sort

Stable Sorting Algorithms: Order should be the same when the value is same.
O(n^2) time and 0(1) space
 */

package Practice;

import java.util.Arrays;

public class bubbleSort {
    static void main() {
        int[] nums = {5, 2, 8, 1, 7, 4, 6, 3};
        System.out.println(Arrays.toString(bubble(nums)));
    }

    static int[] bubble(int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            boolean sorted = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1])
                {
                    sorted = true;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if (!sorted)
                break;
        }
        return nums;
    }
}
