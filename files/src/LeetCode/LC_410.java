/*
410. Split Array Largest Sum
Hard

00:01 read the problem and this is very similar to the book allocation problem from gfg
00:12 made silly mistakes in the code in places
 */

package LeetCode;

public class LC_410 {
    static void main() {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k)
    {
        int start = 0, end = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }


        int cand = 0;
        while (start <= end)
        {
            int mid = start + (end - start)/2;

            if (check(nums, k, mid))
            {
                cand = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return cand;
    }

    public static boolean check(int[] nums, int k, int mid) {
        int count = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > mid) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return count <= k;
    }
}

