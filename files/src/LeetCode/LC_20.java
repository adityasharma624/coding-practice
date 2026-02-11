/*
20. Valid Parentheses
Easy

this is a very famous problem. i know we need to use stack here.
my approach is very verbose, too many if statements, if i use a hashmap to map all the opening and closing brackets, it might be more efficient.
it does work, but it is slower than the if statement code.
 */

package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class LC_20 {
    static void main() {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if ((!stack.isEmpty()) &&
                    map.containsKey(s.charAt(i)) &&
                    (map.get(s.charAt(i)) == stack.peek())){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return (stack.isEmpty());
    }
}
