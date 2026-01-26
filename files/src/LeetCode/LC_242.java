/*
242. Valid Anagram
Easy

00:01 read the problem
00:01 adding a base check checking the size of the two strings
00:02 we can go with sorting O(n log n) both the strings and then comparing?
00:03 implementing the sorting idea
00:06 string1.equals(string2) is different than Arrays.equals(string1, string2)
00:07 accepted, but any other method?
00:07 we can use an array of size 26, and note the number of alphabets and add to that correspondingly
00:08 and when checking the other array, we can deduct from the count, and if it goes negative, it's not anagram.
00:11 accepted, O(n)
 */

package LeetCode;

import java.util.Arrays;

public class LC_242 {
    static void main() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ch = new int[26]; // by default every element is set to 0

        for (char c: s.toCharArray())
        {
            ch[c-'a']++;
        }

        for (char c: t.toCharArray())
        {
            ch[c-'a']--;
            if (ch[c-'a'] < 0) return false;
        }
        return true;
    }

    // My solution
//    static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//
//        char[] first = s.toCharArray();
//        char[] second = t.toCharArray();
//
//        Arrays.sort(first);
//        Arrays.sort(second);
//
//        return Arrays.equals(first, second);
//    }
}
