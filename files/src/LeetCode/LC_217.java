/*
217. Contains Duplicate
Easy

00:01 read the question
00:01 can go with sorting and then checking consecutive element but O(n log n)
00:01 or, we can use hashmap, and finish this in O(n)
00:04 accepted
 */

package LeetCode;

import java.util.HashMap;

public class LC_217 {
    static void main() {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
