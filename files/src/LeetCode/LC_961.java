/*
961. N-Repeated Element in Size 2N Array
Easy

00:01 read the question
00:01 solved this question in python once with set, but can try cycle sort here.
00:09 apparently, did not read the constraints, the numbers are not 1 to N, they are random so cycle sort does not work
00:10 learning hashmap
00:15 hashmap worked, getOrDefault is a nice function (remember)
 */
package LeetCode;

import java.util.HashMap;

public class LC_961 {
    static void main() {
//        int[] nums = {5, 1, 5, 2, 5, 3, 5, 4};
        int[] nums = {2,1,2,5,3,2};
        System.out.println(repeatedNTimes(nums));
    }

    static int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i : nums)
        {

            if (hash.getOrDefault(i, 0) == 0)
            {
                hash.put(i, 1);
            }
            else
            {
                return i;
            }
        }
        return -1;
    }
}
