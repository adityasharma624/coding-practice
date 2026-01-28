package GFG;

import java.util.Arrays;

public class aggressiveCows {
    static void main() {
        int[] stalls = {1,2,4,8,9};
        int k = 3;
        System.out.println(aggressiveCows(stalls, k));;
    }

    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];
        int res = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(stalls, k, mid)) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
    
    static boolean check(int[] stalls, int k, int mid)
    {
        int cnt = 1;        // first cow placed
        int last = 0;       // index of last placed cow

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[last] >= mid) {
                cnt++;
                last = i;
            }
            if (cnt >= k) return true;
        }
        return false;
    }
}
