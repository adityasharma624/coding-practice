import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] load = new int[n];
        for (int i = 0; i < n; i++)
        {
            load[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int t = sc.nextInt();
        int d = sc.nextInt();

        int[] segmentLoadSummary = segmentLoadSum(load, k);
        System.out.println(Arrays.toString(segmentLoadSummary));
        int[] loadDom = histLoadDom(load);
        System.out.println(Arrays.toString(loadDom));
        int earliestStableSegmentPosition = stableOperatingPeriod(segmentLoadSummary, t, d);
        System.out.println(earliestStableSegmentPosition);
        int minReqLoadTol = minimumRequiredLoadLimit(segmentLoadSummary, d);
        System.out.println(minReqLoadTol);
    }

    // Question 1
    static int[] segmentLoadSum(int[] load, int K) {
        int N = load.length;
        int segments = N - K + 1;
        int[] result = new int[segments];

        for (int i = 0; i < segments; i++) {
            int max = load[i];
            for (int j = i; j < i + K; j++) {
                max = Math.max(max, load[j]);
            }
            result[i] = max;
        }

        return result;
    }

    // Question 2
    static int[] histLoadDom(int[] load)
    {
        Stack<Integer> history = new Stack<>();
        int[] result = new int[load.length];

        for (int i = 0; i < load.length; i++) {
            if (history.empty())
            {
                result[i] = -1;
                history.push(i);
            }
            else
            {
                while (!history.empty() && load[history.peek()] < load[i])
                {
                    history.pop();
                }
                if (history.empty()) result[i] = -1;
                else
                {
                    result[i] = history.peek();
                    history.push(i);
                }
            }
        }
        return result;
    }

    // Question 3
    static int stableOperatingPeriod(int[] load, int t, int d) {
        int current = 0;

        for (int i = 0; i < load.length; i++) {
            if (load[i] <= t) {
                current++;
                if (current == d) {
                    return i - d + 2;
                }
            } else {
                current = 0;
            }
        }

        return -1;
    }

    // Question 4
    static int minimumRequiredLoadLimit(int[] load, int d)
    {
        int start = Integer.MAX_VALUE;
        int end = 0;
        for (int l : load)
        {
            if (l > end)
                end = l;
            else if (l < start)
                start = l;
        }
        int cand = 0;
        while (start <= end)
        {
            int mid = start + (end - start)/2;

            if (stableOperatingPeriod(load,mid,d) == -1)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
                cand = mid;
            }
        }
        return cand;
    }
}
