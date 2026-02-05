/*
4. Median of Two Sorted Arrays
Hard

solved this using the merge function of merge sort, but need to look at the binary search approach
 */

package LeetCode;

public class LC_4 {
    static void main() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1,nums2);
        int n = merged.length;
        if (n % 2 == 0) {
            return ((double) merged[n/2 - 1] + merged[n/2]) / 2;
        } else {
            return merged[n/2];
        }
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
