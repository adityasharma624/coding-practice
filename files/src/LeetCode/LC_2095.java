/*
2095. Delete the Middle Node of a Linked List
Medium

i was planning to calculate the length of the list and then n/2, but this is a classic hare and tortoise problem.
i initialize a fast, slow, and a prev (which tracks the previous element of slow, which helps in removing the link of the middle element)
fast moves twice as fast as slow.
and then removal takes place.
 */

package LeetCode;

public class LC_2095 {
    static void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        head = deleteMiddle(head);
        printLL(head);
    }

    public static ListNode deleteMiddle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;
        return head;
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
