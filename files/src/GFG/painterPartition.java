/*
The Painter's Partition Problem
Hard

00:01 read the problem
00:01 trying the allocate minimum page approach
 */

package GFG;

public class painterPartition {
    static void main() {
        int[] arr = {5, 10, 30, 20, 15};
        int k = 3;
        System.out.println(minTime(arr, k));
    }

    public static int minTime(int[] arr, int k) {
        int start = 0, end = 0;

        for (int time : arr)
        {
            start = Math.max(start, time);
            end += time;
        }

        int cand = -1;
        while (start <= end)
        {
            int mid = start + (end - start)/2;

            if (check(arr, k, mid))
            {
                end = mid - 1;
                cand = mid;
            }
            else
            {
                start = mid + 1;
            }
        }

        return cand;
    }

    public static boolean check(int[] arr, int k, int threshold)
    {
        int count = 1;
        int sum = 0;
        for (int time : arr)
        {
            if (sum + time > threshold)
            {
                count++;
                sum = time;
            }
            else
            {
                sum += time;
            }
        }

        return (count <= k);
    }
}
