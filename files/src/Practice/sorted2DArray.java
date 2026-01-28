package Practice;

import java.util.Arrays;

public class sorted2DArray {
    static void main() {
        int[][] nums = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        int target = 13;
        System.out.println(Arrays.toString(binary2d(nums, target)));
    }

    static int[] binary2d(int[][] nums, int target)
    {
        int rStart = 0, rEnd = nums.length-1;
        while (rStart <= rEnd)
        {
            int rMid = rStart + (rEnd - rStart)/2;
            int cStart = 0, cEnd = nums[rMid].length-1;
            if (nums[rMid][cStart] <= target && nums[rMid][cEnd] >= target)
                return OGbinary(nums, rMid, target);
            else if (nums[rMid][cEnd] < target)
                rStart = rMid + 1;
            else if (nums[rMid][cStart] > target)
                rEnd = rMid - 1;
        }
        return new int[] {-1, -1};
    }

    private static int[] OGbinary(int[][] nums, int rMid, int target) {
        int start = 0, end = nums[rMid].length-1;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (nums[rMid][mid] > target)
            {
                end = mid - 1;
            }
            else if (nums[rMid][mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                return new int[] {rMid+1, mid+1};
            }
        }
        return new int[] {-1, -1};
    }


}
