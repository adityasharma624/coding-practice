package Practice;

public class sortedRecursion {
    static void main() {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(isSorted(nums));
    }

    static boolean isSorted(int[] nums)
    {
        return helper(nums, 0);
    }

    static boolean helper(int[] nums, int i)
    {
        if (i == nums.length-1)
            return true;

        if (nums[i] < nums[i+1])
            return helper(nums, i+1);
        else
            return false;
    }
}
