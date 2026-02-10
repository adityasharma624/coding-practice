package Week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q2 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] checkpoints = new int[n][2];
        for (int i = 0; i < n; i++) {
            checkpoints[i][0] = scanner.nextInt();
            checkpoints[i][1] = scanner.nextInt();
        }
        int supplies = scanner.nextInt();
        scanner.close();

        Arrays.sort(checkpoints, Comparator.comparingInt(a -> a[0]));

        int currentHeight = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int height = checkpoints[i][0];
            int gain = checkpoints[i][1];
            int cost = height - currentHeight;
            if (supplies < cost) {
                break;
            }
            supplies -= cost;
            supplies += gain;
            currentHeight = height;
            count++;
        }

        System.out.println(count);
    }
}
