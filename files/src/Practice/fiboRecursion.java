package Practice;


// Find nth fibonacci number
public class fiboRecursion {
    static void main() {
        System.out.println(nthFibo(10));
    }

    public static int nthFibo(int n)
    {
        if (n <= 1)
            return n;
        return nthFibo(n-1) + nthFibo(n-2);
    }

}
