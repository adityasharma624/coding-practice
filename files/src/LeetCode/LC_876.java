/*
876. Middle of the Linked List
Easy

00:01 using slow and fast pointers. slow will move one node at a time, meanwhile fast moves two nodes at a time, if fast or fast.next is null, we return slow
00:03 accepted
 */

package LeetCode;

public class LC_876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode middle = middleNode(head);

        System.out.println("Middle node value: " + middle.val);
    }

    public static ListNode middleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
