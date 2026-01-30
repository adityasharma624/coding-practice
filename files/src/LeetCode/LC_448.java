/*
448. Find All Numbers Disappeared in an Array
Easy

00:01 this question is supposed to be sort using cyclic sort, but i am having a bit of confusion, wouldn't it go out of bounds
00:02 or wait we can create a clone of this array, with a greater size, say the size of the largest element, or the actual size of the list (cause 1 to n)
00:03 trying to implement that
00:05 i am not able to understand how would this work in the case of [1,1] it will just be an infinite loop no?
00:06 or or, if we see that it is a duplicate we turn the element to 0 woah yes. wait.
00:10 infinite loop for some reason. they have placed numbers very intelligently, so that if we swap them we are stuck in an infinite loop
00:12 no, i wrote the code wrong.
00:14 simple cyclic sort, no need to 0 the duplicates, duplicates will adjust themselves appropriately
00:20 i think i have not implemented cyclic sort correctly, checking the code.
00:24 oh ok, so the swap that i am doing is wrong, i use nums[i] again and again which gets changed in the swap
00:27 i need to revise cyclic sort
 */

package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class LC_448 {
    static void main() {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    static public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length)
        {
            if (nums[i] != nums[nums[i]-1])
            {
                int correct = nums[i]-1;
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else
            {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1)
                result.add(j+1);
        }
        return result;
    }
}
