package Practice;

public class recursionSumofDigits {
    static void main() {
        System.out.println(sumDigits(1536));
    }

    static int sumDigits(int n)
    {
        if (n == 0)
            return 0;
        int digit = n%10;
        return digit + sumDigits(n/10);
    }
}
