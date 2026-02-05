/*
3. Longest Substring Without Repeating Characters
Medium

00:01 read the problem
00:01 hashmaps? everytime we encounter a duplicate, a new hashmap, while taking a count
00:06 not working with "pwwkew"
00:08 when i clear the hashmap, i am not "putting" in the current character, so the count is skewed.
00:09 edgecases are not working out
00:16 misinterpreted the question. i want the longest substring without duplicate characters
00:16 in dvdf, the output i give is 2 because "df", but they expect "vdf".
00:19 can't figure out
00:20 took a hint, sliding window and hashtable must be used
00:25 accepted, but beats only 5% solutions.

aftermath: the optimized code was basically, taking a left and right pointer. we move the right pointer, and check whether the current character is already in the hashmap. if yes, we move left to max(left, map.get(c)+1), because the character in the map might not be relevant, we put the new occurrence of c. and then update maxLen to max(maxLen, right - left + 1).
 */

package LeetCode;

import java.util.HashMap;

public class LC_3 {
    static void main() {
        System.out.println(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            if (map.containsKey(c))
                left = Math.max(left, map.get(c) + 1);
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int mylengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();

        int maxLen = 1;
        for (int window = 2; window <= s.length(); window++) {
            for (int index = 0; index < s.length()-window+1; index++) {
                if (isUnique(s, index, window)) {
                    maxLen = window;
                    break;
                }
            }
            if (maxLen < window) return maxLen;
        }
        return maxLen;
    }

    public static boolean isUnique(String s, int i, int window)
    {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int j = i; j < i + window; j++) {
            if (map.getOrDefault(s.charAt(j), false))
            {
                return false;
            }
            else
            {
                map.put(s.charAt(j), true);
            }
        }
        return true;
    }

}
