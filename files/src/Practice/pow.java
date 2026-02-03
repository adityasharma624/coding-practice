package Practice;

public class pow {
    static void main() {
        System.out.println(powxn(2, 3));
    }

    static int powxn(int x, int n)
    {
        if (n == 1)
            return x;
        return x * powxn(x,n-1);
    }
}
