package CF;

import java.util.Scanner;

public class A282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int no_of_iterations = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        int result = 0;

        while (no_of_iterations > 0) {
            String input = sc.nextLine();

            if (input.charAt(1) == '+')
                result++;
            else
                result--;

            no_of_iterations--;
        }

        System.out.println(result);
    }
}
