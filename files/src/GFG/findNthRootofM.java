/*
Find nth root of m
Medium

00:01 read the problem
00:02 trying to bruteforce the binary search's helper function
 */

package GFG;

public class findNthRootofM {
    static void main() {
        System.out.println(nthRoot(4, 16));
    }

    public static int nthRoot(int n, int m) {
        // code here
        if (n == 0)
            return 0;
        if (m == 1)
            return m;

        int start = 0, end = m;
        while (start <= end)
        {
            int mid = start + (end - start)/2;

            int val = (int)Math.pow(mid, n);

            if (val == m)
                return mid;
            else if (val > m)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}
