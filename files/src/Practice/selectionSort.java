/*
select an element and put it in its right position
i was accidentaly comparing an index with a number
 */

package Practice;

import java.util.Arrays;

public class selectionSort {
    static void main() {
        int[] nums = {5, 2, 8, 1};
        System.out.println(Arrays.toString(selection(nums)));
    }

    static int[] selection(int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            int last = nums.length - i - 1;
            int maxIndex = getMaxIndex(nums, 0, last);
            swap(nums, maxIndex, last);

        }
        return nums;
    }

    static void swap(int[] nums, int maxIndex, int last)
    {
        int temp = nums[maxIndex];
        nums[maxIndex] = nums[last];
        nums[last] = temp;
    }

    static int getMaxIndex(int[] nums, int start, int end)
    {
        int resultIndex =0;
        for (int i = start; i < end+1; i++) {
            if (nums[resultIndex] < nums[i])
                resultIndex = i;
        }
        return resultIndex;
    }
}
