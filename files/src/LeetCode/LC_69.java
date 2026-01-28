/*
69. Sqrt(x)
Easy

00:01 read the problem, looks like a monotonic function question
00:04 solves the test case
00:05 i tried checking for the boundary where truth starts, ig i need to approach it differently
00:10 lower bound should not be 1 rather 0, for the case of 1.
00:11 wrong assumption, end should be x, cause of 1.
00:12 is 2147395599 inside the scope? it is, i am schwepid.
00:15 2147395599*2147395599 becomes negative, so we need to use (long) 2147395599*2147395599;
 */

package LeetCode;

public class LC_69 {
    static void main() {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    static int mySqrt(int x)
    {
        if (x == 0 || x == 1)
            return x;
        int start = 0;
        int end = x;
        int result = 0;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (sqrLess(mid, x))
            {
                end = mid - 1;
            }
            else
            {
                result = mid;
                start = mid + 1;

            }
        }
        return result;
    }

    static boolean sqrLess(int x, int target)
    {
        return (long) x*x > target;
    }
}
