package Practice;

import java.util.ArrayList;
import java.util.Arrays;

// subsets and subsequences are different.
// all subsequences are subsets, but not all subsets are subsequences.
// order matters in subsequences.
// this file contains subsequences question

public class subsets {
    // whenever permutations and combinations
    // subsets -> non adjacent collections
    // ordering cannot change
    static void main() {
        String str = "abc";
        // subsets must be ["a", "b", "c", "ab", "ac", "bc", "abc"]
        // This pattern of taking some elements and removing some is known as this subset pattern
        System.out.println(findSubsetsRet("", str));
        findSubsets("", str);
        System.out.println();
        findSubsetsASCII("", "abc");
    }

    // subset with ASCII value
    static void findSubsetsASCII(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.print(p + " ");
            return;
        }

        findSubsetsASCII(p + up.charAt(0), up.substring(1));
        findSubsetsASCII(p + (up.charAt(0)+0), up.substring(1));
        findSubsetsASCII(p, up.substring(1));
    }


    // subsets not returning, just printing
    static void findSubsets(String p, String up)
    {
        if (up.isEmpty())
        {
            System.out.print(p + " ");
            return;
        }
        findSubsets(p + up.charAt(0), up.substring(1));
        findSubsets(p, up.substring(1));
    }

    // subsets returning an ArrayList
    static ArrayList<String> findSubsetsRet(String p, String up)
    {
        if (up.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = findSubsetsRet(p + up.charAt(0), up.substring(1));
        ArrayList<String> right = findSubsetsRet(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
