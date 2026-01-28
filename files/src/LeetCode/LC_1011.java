/*
1011. Capacity To Ship Packages Within D Days
Medium

00:01 read the problem. this is similar to the book allocation problem. we need to run a binary search on from i guess largest to sum of array?
00:07 the code is returning the start, i guess instead of the minimum load it is returning the minimum, that means instead of the boundary, it is just returning the start
00:14 a silly mistake, everything in the code was right, i was actually comparing the number of days it takes with the min load instead of the given days constraint.
00:16 accepted
 */

package LeetCode;

public class LC_1011 {
    static void main() {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int start = weights[0];
        int end = 0;
        for (int weight : weights)
        {
            end += weight;
            if (start < weight)
            {
                start = weight;
            }
        }

        int result = 0;
        while (start <= end)
        {
            int mid = start + (end - start)/2;

            if (check(weights, days, mid))
            {
                end = mid - 1;
                result = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return result;
    }

    public static boolean check(int[] weights, int days, int k)
    {
        int sum = 0;
        int count = 1;
        for (int weight : weights)
        {
            if (sum + weight > k){
                sum = weight;
                count++;
            }
            else
            {
                sum += weight;
            }

            if (count > days) return false;
        }

        return (count <= days);
    }
}
