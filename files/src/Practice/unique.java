package Practice;

public class unique {
    static void main() {
        System.out.println(countNumbersWithinUniqueDigits(10));
    }

    static int countNumbersWithinUniqueDigits(int n) {
        if (n == 0) return 1;

        n = Math.min(n, 10);

        int result = 10;
        int current = 9;
        int available = 9;

        for (int i = 2; i <= n; i++) {
            current *= available;
            result += current;
            available--;
        }

        return result;
    }
}
