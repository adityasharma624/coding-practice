/*
Allocate Minimum Pages
Medium

00:01 i remember this question, i skipped it

 */

package GFG;

public class allocateMinPages {
    static void main() {
        int[] arr = {12,34,67,90};
        int k = 2;
        System.out.println(findPages(arr, k));
    }

    static int findPages(int[] arr, int k)
    {
        if (arr.length < k)
            return -1;

        int start = 0, end = 0;
        for (int book : arr)
        {
            end += book;
            start = Math.max(start, book);
        }

        int cand = -1;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (check(arr, k, mid))
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

    static boolean check(int[] arr, int k, int threshold)
    {
        int count = 1;
        int sum = 0;
        for (int book : arr)
        {
            if (sum + book > threshold)
            {
                count++;
                sum = book;
            }
            else
            {
                sum += book;
            }
        }

        return count <= k;
    }
}
