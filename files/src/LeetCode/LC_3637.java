/*
3637. Trionic Array I
Easy
 */

package LeetCode;

public class LC_3637 {
    static void main() {
        int[] nums = {2,1,3};
        System.out.println(isTrionic(nums));
    }

    public static boolean isTrionic(int[] nums) {
        int check = 0;
        boolean isAsc = true;
        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] > nums[i+1] && isAsc)
            {
                check++;
                isAsc = !isAsc;
            }
            else if (nums[i] < nums[i+1] && !isAsc)
            {
                check++;
                isAsc = !isAsc;
            }
        }
        return (isAsc && check == 2);
    }
}
