package Practice;

public class recursionMessage {
    static void main() {
        message(5);
    }

    static void message(int n)
    {
        if (n == 0)
            return;
        System.out.println("Hello, World! " + n);
        message(n-1);
    }
}
