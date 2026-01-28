/*
1539. Kth Missing Positive Number
Easy

this question seems pretty easy at first, but trying to come up with a binary search solution is a bit difficult.
i think it is more of a pattern question where you have to know the pattern.
*/

package LeetCode;

public class LC_1539 {
    static void main() {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end)
        {
            int mid = start + (end - start)/2;

            int missingNumbersTillNow = arr[mid] - (mid + 1);

            if (missingNumbersTillNow < k)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return start + k;
    }
}
