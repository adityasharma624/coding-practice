/*
1482. Minimum Number of Days to Make m Bouquets
Medium

00:04 it's been four minutes, and i am not able to understand the question
00:07 asking chatgpt to explain it
00:11 ok, so basically, this is again a monotonic function question, i need to find the minimum day where we can use k consecutive flowers to use for bouquets. alright.
00:11 so i need to create a function first which checks for consecutive flowers.
00:14 some sort of sliding window for checking whether it works or not
00:21 does not work, some issue somewhere
00:27 i am not running the binary search on the bloomDay array, rather i should run it on the array of possible numbers
00:29 now it works, let's test it out on the sample test cases
00:30 giving out errors on the bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
00:31 didn't add an else for a case where the adjacent elements break
00:32 feeling like it'd give out a tle, on the other hand, it gave the wrong answer on 92/93
00:34 it doesn't work because i guess of the int bounds
00:36 sometimes the result ends up showing 0 for an answer, need to add a check for 0, if 0 then -1 should be returned.
00:37 accepted, but very slow solution.
00:37 i will check for the optimal solution
 */

package LeetCode;

import java.util.Arrays;

public class LC_1482 {
    static void main() {
        int[] nums = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(minDays(nums, m, k));
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k)
            return -1;

        int start = 0, end = bloomDay.length-1;

        for(int day : bloomDay)
        {
            end = Math.max(end, day);
        }

        int result = start;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (canBouquet(bloomDay, m, k, mid))
            {
                result = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        if (result == 0) return -1;
        return result;
    }

    static boolean canBouquet(int[] bloomDay, int m, int k, int d)
    {
        int[] bloom = Arrays.copyOf(bloomDay, bloomDay.length);
        for (int i = 0; i < bloom.length; i++) {
            if (bloom[i] <= d)
            {
                bloom[i] = -1;
            }
        }

        int curr = 0;
        for (int i = 0; i < bloom.length; i++) {
            if (bloom[i] == -1)
            {
                curr++;
                if (curr == k){
                    curr = 0;
                    m--;
                }
            }
            else
            {
                curr=0;
            }
        }

        return m<=0;
    }
}
