package Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class permutations {
    // permutations of 'abc' are
    // 'abc', 'bac', 'cab', 'bca', acb', etc.
    static void main() {
        permutation("", "abc");
        System.out.println(permutationRet("", "abc"));
    }

    static ArrayList<String> permutationRet(String p, String up)
    {
        if (up.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans.addAll(permutationRet(f + up.charAt(0) + s, up.substring(1)));
        }
        return ans;
    }

    static void permutation(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.print(p + " ");
            return;
        }

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            permutation(f + up.charAt(0) + s, up.substring(1));
        }

    }
}
