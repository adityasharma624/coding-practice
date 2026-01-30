/*
for every index you are at, put that index element at the correct index of left hand side.
we start from index 1, we check it's place in the left hand side, and then move forward.
shift elements to right to make room to insert value
 */

package Practice;

import java.util.Arrays;

public class insertionSort {
    static void main() {
        int[] nums = {6, 1, 7, 4, 2, 9, 8, 5, 3};
        System.out.println(Arrays.toString(insert(nums)));
    }

    private static int[] insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp)
            {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
        return nums;
    }


}
