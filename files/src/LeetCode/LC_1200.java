/*
1200. Minimum Absolute Difference
Easy

00:01 read the question
00:01 similar to 1984 we need to sort the array first
00:01 maybe one iteration for finding the minimum difference, and other for listing the values?
00:02 learning <List<List<Integer>>
00:10 <List<List<Integer>> is weird
 */

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1200 {
    static void main() {
        int[] arr = {4,2,1,3};
        System.out.println(minimumAbsDifference(arr));
    }

    static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] < minAbs)
            {
                minAbs = arr[i+1] - arr[i];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] == minAbs)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                result.add(temp);
            }
        }
        return result;
    }
}


