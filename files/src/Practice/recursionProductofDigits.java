package Practice;

public class recursionProductofDigits {
    static void main() {
        System.out.println(prodDigits(12345));
    }

    static int prodDigits(int n)
    {
        if (n == 1)
            return 1;
        return (n%10) * prodDigits(n/10);
    }
}
