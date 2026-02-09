/*
234. Palindrome Linked List
Easy

Reversing the list to half. and then traversing the linked list.
the problem with my approach was i didn't think how i'll start cuz head will be the last element of the reversed array.
but we reverse the links, and we keep the nodes, and then traverse, would be a better option.
but first we need to find the length of the linked list.
 */

package LeetCode;

public class LC_234 {
    static void main() {
        int[] values = {0, 2, 2, 1};

        ListNode head = new ListNode(values[0]);
        ListNode curr = head;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }

        System.out.println(isPalindrome(head));;
    }

    public static boolean isPalindrome(ListNode head)
    {
        if (head == null)
            return false;
        if (head.next == null)
            return true;
        if (head.next.next == null)
        {
            int val1 = head.val;
            int val2 = head.next.val;
            return val1 == val2;
        }
        if (head.next.next.next == null)
        {
            int val1 = head.val;
            int val2 = head.next.next.val;
            return val1 == val2;
        }

        int length = lengthLL(head);
        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = curr.next;

        while (count < length/2)
        {
            count++;
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }

        if (length%2 == 0)
        {
            while (prev != null && curr != null)
            {
                int val1 = curr.val;
                int val2 = prev.val;
                prev = prev.next;
                curr = curr.next;
                if (val1 != val2)
                    return false;
            }
        }
        else
        {
            while (prev != null && temp != null)
            {
                int val1 = prev.val;
                int val2 = temp.val;
                prev = prev.next;
                temp = temp.next;
                if (val1 != val2)
                    return false;
            }
        }
        return true;
    }

    public static int lengthLL(ListNode head)
    {
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
