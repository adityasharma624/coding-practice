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

        int end = 0;
        int start = arr[0];
        for (int page : arr) {;
            end += page;
            start = Math.max(start, page);
        }

        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPage(arr, k, mid))
            {
                ans = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPage(int[] arr, int k, int mid)
    {
        int students = 1;
        int sum = 0;
        for (int page : arr)
        {
            if (sum + page > mid)
            {
                students++;
                sum = page;
            }

            if (students > k)
                return false;
            else
                sum += page;
        }

        return true;
    }
}
