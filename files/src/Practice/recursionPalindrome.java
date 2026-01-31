package Practice;

public class recursionPalindrome {
    static String temp = "";
    static void main() {
        System.out.println(isPalindrome("abba"));
    }

    static boolean isPalindrome(String input)
    {
        helper(input, input.length()-1);
        return (input.equals(temp));
    }

    static void helper(String input, int length)
    {
        if (length == -1) return;
        temp = temp + input.charAt(length);
        helper(input, length-1);
    }
}
