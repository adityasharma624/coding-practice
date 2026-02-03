package Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class grayCode {
    static void main() {
        System.out.println(gray(10));
    }

    static ArrayList<Integer> gray(int A)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int total = 1 << A;
        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
