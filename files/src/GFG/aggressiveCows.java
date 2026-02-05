/*
Aggressive Cows
Medium

00:01 read the problem, binary search on answer
00:02 use mid to check how many cows using that minimum distance, if not enough, update start, if enough, update end
00:06 not working, some issues in the helper function
00:07 i need to run the helper function on distances not the values.

misinterpreted the question, i need to find the largest value which works. so start and end update accordingly. also in check, i am not checking for partitions rather placing cows.
we place the first cow at index 0, and then check whether the current index - last placed is greater than mid, and then we increment the count accordingly.

 */

package GFG;

import java.util.Arrays;

public class aggressiveCows {
    static void main() {
        int[] stalls = {2, 12, 11, 3, 26, 7};
        int k = 3;
        System.out.println(aggressiveCows(stalls, k));;
    }

    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int end = stalls[stalls.length-1] - stalls[0];
        int start = 0;

        int cand = 0;
        while (start <= end)
        {
            int mid = start + (end - start)/2;

            if (check(stalls, k, mid))
            {
                cand = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return cand;
    }

    static boolean check(int[] stalls, int k, int mid)
    {
        int cows = 1;
        int lastPlaced = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= mid) {
                cows++;
                lastPlaced = stalls[i];
            }

            if (cows >= k) return true;
        }
        return false;
    }
}
