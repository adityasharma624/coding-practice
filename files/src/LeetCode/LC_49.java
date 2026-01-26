/*
49. Group Anagrams
Medium

00:01 reead the problem
00:01 considering the length is 10^4, we have to solve this in n or nlogn.
00:02 we can go through the list, and replace the elements with their sorted alternate.
00:03 then another loop to check which elements are same and put them in a list, and remove them from the original list.
00:03 but this might become some sort of n^2logn solution. let's implement this first
00:07 not a good idea
00:14 we can use a hashmap, woah, wait
00:23 holy shit it works aaaaaaaa
00:23 accepted lesgoooo

so my code is a lot more verbose than one of the solutions i saw
*/

package LeetCode;

import java.util.*;

public class LC_49 {
    static void main() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    static List<List<String>> groupAnagramsSoln(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);

            if (!map.containsKey(temp))
            {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(s);
        }
        return new ArrayList<>(map.values());
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        String[] copy = Arrays.copyOf(strs, strs.length);
        for (int i = 0; i < copy.length; i++) {
            char[] temp = copy[i].toCharArray();
            Arrays.sort(temp);
            String tempo = new String(temp);
            copy[i] = tempo;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            if (map.containsKey(copy[i]))
            {
                List<String> temp = map.get(copy[i]);
                temp.add(strs[i]);
                map.put(copy[i], temp);
            }
            else
            {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(copy[i], temp);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            result.add(entry.getValue());
        }
        return result;
    }
}
