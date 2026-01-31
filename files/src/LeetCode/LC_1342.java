/*
1342. Number of Steps to Reduce a Number to Zero
Easy

00:01 read the problem
00:01 this can be solved both iteratively and recursively, let's try out recursion.
00:05 the code is running perfectly in IDEA but not in LeetCode.
00:06 somehow the static keyword was causing issues with the answer.
00:07 trying to solve this without the static vairable
 */

package LeetCode;

public class LC_1342 {
    static void main() {
        int num = 8;
        System.out.println(numberOfSteps(num));
    }

    public static int numberOfSteps(int num)
    {
        if (num == 0) return 0;

        if (num%2==0)
            return 1 + numberOfSteps(num/2);
        else
            return 1 + numberOfSteps(num-1);
    }
}
