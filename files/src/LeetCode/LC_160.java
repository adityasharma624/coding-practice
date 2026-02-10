/*
160. Intersection of Two Linked Lists
Easy

00:03 can create a hashtable which stores values and the listnode memory reference, we first go through a, then b, and check the intersection.
00:03 implementing it
00:07 accepted, but i wanted to get the solution in O(m+n) time and O(1) space.
checked the faster solution by mistake, we basically check both list's lengths, and then get the pointers on the same length, start comparing, if equal then return else no return
00:14 accepted
 */

package LeetCode;

import java.util.HashMap;

public class LC_160 {
    static void main() {

    }

    public static ListNode FastergetIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode temp = headA;
        while (temp != null)
        {
            ++lenA;
            temp = temp.next;
        }

        int lenB = 0;
        temp = headB;
        while (temp != null)
        {
            ++lenB;
            temp = temp.next;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;

        if (lenA > lenB)
        {
            for (int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }
        }
        else
        {
            for (int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }

        while (tempA != null)
        {
            if (tempA == tempB)
                return tempA;

            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();

        ListNode temp = headA;
        while (temp != null)
        {
            map.put(temp, temp.val);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null)
        {
            if (map.containsKey(temp))
            {
                return temp;
            }
            else
            {
                temp = temp.next;
            }
        }
        return null;
    }
}
