/*
17. Letter Combinations of a Phone Number
Medium

 */

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC_17 {
    static void main() {
        System.out.println(letterCombinations("","23"));
    }

    static String[] keypad = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static List<String> letterCombinations(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        String letters = keypad[digit];

        List<String> result = new ArrayList<>();
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            result.addAll(letterCombinations(p + ch, up.substring(1)));
        }
        return result;
    }
}
