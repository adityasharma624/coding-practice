/*
K-th element of two Arrays
Medium

00:01 read the problem
00:01 will try to brute force this question by merging both the arrays and just getting the index.
00:07 this solution works, but this was listed under binary search questions, so there must be more.
00:10 the expected approach is binary search, I KNEW IT, THERE ARE TWO BINARY SEARCHES AAAAAAAA
00:11 not exactly the approach i was thinking
 */

package GFG;

import java.util.Arrays;

public class kthElementofTwoArrays {
    static void main() {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElementofTwoArrays(a,b,k));
    }

    public static int kthElementofTwoArrays(int[] a, int[] b, int k)
    {
        int[] merged = merge(a,b);
        System.out.println(Arrays.toString(merged));
        return merged[k-1];
    }

    public static int[] merge(int[] a, int[] b)
    {
        int i = 0, j = 0, n = a.length, m = b.length, k = 0;
        int[] merged = new int[n + m];
        while (i < n && j < m)
        {
            if (a[i] < b[j])
            {
                merged[k++] = a[i++];
            }
            else
            {
                merged[k++] = b[j++];
            }
        }

        while (i < n)
        {
            merged[k++] = a[i++];
        }

        while (j < m)
        {
            merged[k++] = b[j++];
        }

        return merged;
    }
}
