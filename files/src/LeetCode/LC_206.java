/*
206. Reverse Linked List
Easy


 */

package LeetCode;

public class LC_206 {
    static void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode newHead = reverse(head);
        printLL(newHead);
        ListNode anotherHead = reverseRecursion(null, newHead);
        printLL(anotherHead);
    }

    private static ListNode reverseRecursion(ListNode prev, ListNode curr)
    {
        if (curr == null)
            return prev;

        ListNode temp = curr.next;
        curr.next = prev;
        return reverseRecursion(curr, temp);
    }

    private static ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static void printLL(ListNode root)
    {
        ListNode temp = root;
        while (temp!=null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
