package LeetCode;

import java.util.Arrays;

public class LC_3379 {
    static void main() {
        int[] nums = {3, -2, 1, 1};
        System.out.println(Arrays.toString(constructTransformedArray(nums)));
    }

    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int index = ((i + nums[i]) % n + n) % n;
            result[i] = nums[index];
        }

        return result;
    }
}
