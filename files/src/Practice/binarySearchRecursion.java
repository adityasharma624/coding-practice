package Practice;

public class binarySearchRecursion {
    static void main() {
        int[] nums = {1, 10, 17, 25, 33, 50, 99};
        System.out.println(binarySearch(nums, 49, 0, nums.length-1));
    }

    static boolean binarySearch(int[] nums, int target, int start, int end)
    {
        if (start > end)
            return false;
        int mid = start + (end - start)/2;
        if (nums[mid] == target)
            return true;
        else if (nums[mid] < target)
            return binarySearch(nums, target, mid + 1, end);
        else
            return binarySearch(nums, target, start, mid - 1);
    }
}
