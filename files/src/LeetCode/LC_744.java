/*
744. Find Smallest Letter Greater Than Target
Easy

00:01 read the question, it is a binary search with characters
00:01 cleared the edge case by returning letters[0]
00:04 if the letter is greater end = mid - 1, if letter is equal to or smaller than target start = mid + 1;
00:05 accepted
 */

package LeetCode;

public class LC_744 {
    public static void main(String[] args) {
        char[] letters = {'x','x', 'y', 'y'};
        char target = 'z';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length-1;
        int cand = -1;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (letters[mid] > target)
            {
                cand = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        if (cand == -1) return letters[0];
        return letters[cand];
    }
}
