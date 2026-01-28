/*
1283. Find the Smallest Divisor Given a Threshold
Medium

00:01 this looks similar to the koko banana problem
00:04 a confusion where to do start<=end and where start<end
00:05 the ceiling function was (num + k - 1)/k
00:08 passes the test case
00:09 i keep forgetting that this is a binary search on the answer
00:10 accepted. start = 1.
 */

package LeetCode;

public class LC_1283 {
    static void main() {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        System.out.println(smallestDivisor(nums, threshold));
    }

    static int smallestDivisor(int[] nums, int threshold)
    {
        int start = 1;
        int end = 0;

        for (int num : nums)
        {
            if (num > end)
                end = num;
        }
        int res = 0;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (check(nums, threshold, mid))
            {
                end = mid - 1;
                res = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return res;
    }

    private static boolean check(int[] nums, int threshold, int mid) {
        int sum = 0;
        for (int num : nums)
        {
            int ceil = (num + mid - 1)/mid;
            sum += ceil;
        }

        if (sum <= threshold)
            return true;
        return false;
    }


}
