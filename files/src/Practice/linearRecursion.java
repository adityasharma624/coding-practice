package Practice;

public class linearRecursion {
    static void main() {
        int[] nums = {1, 10, 17, 25, 33, 50, 99};
        int target = 17;
        System.out.println(linear(nums, target, 0));
    }

    static boolean linear(int[] nums, int target, int index)
    {
        if (index == nums.length)
            return false;

        if (nums[index] == target)
            return true;
        else
            return linear(nums, target, index+1);
    }
}
