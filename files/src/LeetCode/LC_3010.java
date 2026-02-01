package LeetCode;

public class LC_3010 {
    static void main() {
        int[] nums = {10, 3, 1, 1};
        System.out.println(minimumCost(nums));
    }

    public static int minimumCost(int[] nums)
    {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums)
        {
            if (num < min1)
                min1 = num;
            else if (num < min2)
                min2 = num;
        }
        return nums[0] + min1 + min2;
    }
}
