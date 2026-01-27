/*
875. Koko Eating Bananas
Medium

00:01 read and understood the problem
00:01 what if we treat this is as an infinite array problem, but instead of comparing it with a target, we check whether the right pointer satisfies the condition, and then do binary search.
00:02 the only problem that this causes is too many operations, let's implement this first
00:09 calculation logic faltering
00:17 i was checking whether total / k <= h, where i had to check only total <= h, such a dumbass i am.
00:20 formed an answer
00:21 accepted mf lesgooooooo

alright, so i checked out the better solution, basically what i was doing wrong was that i was looking at this like an infinite array, the most hours koko will take to eat a pile is the maximum element of the array considering banana per hour rate is 1.
another mistake i was doing was i was using math.ceil() for ceiling calculation, a simpler option would have been, "(pile + k - 1) / k".
another thing, you can take the available hours, and just deduct the ceiling calculation from it, and as soon as it goes negative, return false, else return true.
baaki, my code was good, proud of myself.
 */

package LeetCode;

public class LC_875 {
    static void main() {
        int[] piles = {30,11,23,4,20};
        int h = 5;
//        int[] piles = {3,6,7,11};
//        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }


    // Leetcode Solution
    public static int minEatingSpeedLC(int[] piles, int h) {
        int start = 1;
        int end = h;
        for (int pile : piles)
        {
            end = Math.max(end, pile);
        }

        while (start <= end)
        {
            int mid = start + (end - start)/h;
            if (canEat(piles, h, mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static boolean canEat(int[] piles, int h, int k)
    {
        int availHours = h;

        for (int pile : piles)
        {
            availHours -= (pile + k - 1)/k;

            if (availHours < 0) return false;
        }

        return (availHours >= 0);
    }


    // My Solution
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 0, end = 1;

        // finding the bounds
        while (true)
        {
            if (!canEatBanana(piles, h, end))
            {
                start = end;
                end = end * 2;
            }
            else
            {
                break;
            }
        }

        int cand = 0;
        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if (canEatBanana(piles, h, mid))
            {
                cand = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return cand;
    }

    public static boolean canEatBanana(int[] piles, int h, int k)
    {
        double total = 0;
        for (double pile : piles)
        {
            total = total + Math.ceil(pile / k);
        }
        if (total <= h)
            return true;
        return false;
    }


}
