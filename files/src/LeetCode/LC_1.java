/*
1. Two Sum
Easy

00:01 i know that this problem is approached using hashmaps
00:01 we can store entries into hashmap
00:02 {target-current:index}
00:07 some bug in my code
00:10 was checking for complements inside the map instead of the element itself
00:14 accepted
 */

package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LC_1 {
    static void main() {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(nums[i]))
            {
                int ind = map.get(nums[i]);
                return new int[] {i, ind};
            }
            else
            {
                map.put(complement, i);
            }
        }
        return new int[] {-1,-1};
    }
}
