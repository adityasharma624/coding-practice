package Practice;

public class recursionReverse {
    static int sum = 0;
    static void main() {
        reverse(12345);
        System.out.println(sum);
    }


    static void reverse(int n)
    {
        if (n == 0)
            return;

        int digit = n%10;
        sum = sum*10 + digit;
        reverse(n/10);
    }
}
